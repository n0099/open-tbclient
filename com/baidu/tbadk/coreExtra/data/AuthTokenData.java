package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AuthTokenData implements Serializable {
    public String authToken;
    public int errorCode;

    public static AuthTokenData parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AuthTokenData authTokenData = new AuthTokenData();
        authTokenData.parseJsonObj(jSONObject);
        return authTokenData;
    }

    private void parseJsonObj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.errorCode = jSONObject.optInt("error_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject != null) {
            this.authToken = optJSONObject.optString("pass_token");
        }
    }

    private void parseJsonStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.errorCode = jSONObject.optInt("error_code");
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject != null) {
                this.authToken = optJSONObject.optString("pass_token");
            }
        } catch (JSONException unused) {
        }
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public static AuthTokenData parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AuthTokenData authTokenData = new AuthTokenData();
        authTokenData.parseJsonStr(str);
        return authTokenData;
    }
}
