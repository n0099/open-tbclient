package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AccessState implements Serializable {
    private static final long serialVersionUID = 2345844599685454996L;
    private String token;
    private String type;
    private UserInfo userInfo = new UserInfo();

    public String getType() {
        return this.type;
    }

    public String getToken() {
        return this.token;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void parserJson(String str) {
        JSONObject optJSONObject;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("info")) != null) {
                    parserJson(optJSONObject.optJSONObject(AccountAccessActivityConfig.KEY_ACCESS_STATE));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = jSONObject.optString("type");
                this.token = jSONObject.optString(Constants.EXTRA_KEY_TOKEN);
                JSONObject jSONObject2 = jSONObject.getJSONObject("userinfo");
                if (jSONObject2 != null) {
                    this.userInfo.strMobile = jSONObject2.optString("strMobile");
                    this.userInfo.strEmail = jSONObject2.optString("strEmail");
                    this.userInfo.bduss = jSONObject2.optString("bduss");
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public class UserInfo implements Serializable {
        public String bduss;
        public String strEmail;
        public String strMobile;

        public UserInfo() {
        }
    }
}
