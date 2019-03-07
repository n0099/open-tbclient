package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.sapi2.activity.social.WXLoginActivity;
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
        authTokenData.aN(jSONObject);
        return authTokenData;
    }

    public static AuthTokenData parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AuthTokenData authTokenData = new AuthTokenData();
        authTokenData.nB(str);
        return authTokenData;
    }

    private void aN(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject != null) {
                this.authToken = optJSONObject.optString("pass_token");
            }
        }
    }

    private void nB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.errorCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
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
