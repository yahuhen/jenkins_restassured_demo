import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoApiTest {

    public static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("https://api.icndb.com")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    public void getRandomJokeTest() {

        String response = RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get("/jokes/random")
                .then()
                .extract().body().asString();

        Assert.assertTrue(response.contains("joke"), "there is no joke indicated in response!");
    }

    @Test
    public void get3RandomJokeTest() {

        String response = RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get("jokes/random/3")
                .then()
                .extract().body().asString();

        Assert.assertTrue(response.contains("joke"), "there is no joke indicated in response!");
    }

}
