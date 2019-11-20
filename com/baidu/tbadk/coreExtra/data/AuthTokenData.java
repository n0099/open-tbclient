package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AuthTokenData implements Serializable {
    private String authToken;
    public int errorCode;

    public static AuthTokenData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AuthTokenData authTokenData = new AuthTokenData();
        authTokenData.by(jSONObject);
        return authTokenData;
    }

    public static AuthTokenData parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AuthTokenData authTokenData = new AuthTokenData();
        authTokenData.oJ(str);
        return authTokenData;
    }

    private void by(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errorCode = jSONObject.optInt("error_code");
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.LAUNCH_INFO);
            if (optJSONObject != null) {
                this.authToken = optJSONObject.optString("pass_token");
            }
        }
    }

    private void oJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt("error_code");
                JSONObject optJSONObject = jSONObject.optJSONObject(Config.LAUNCH_INFO);
                if (optJSONObject != null) {
                    this.authToken = optJSONObject.optString("pass_token");
                }
            } catch (JSONException e) {
            }
        }
    }

    public String getAuthToken() {
        return this.authToken;
    }
}
