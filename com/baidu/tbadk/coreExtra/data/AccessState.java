package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AccessState implements Serializable {
    public static final long serialVersionUID = 2345844599685454996L;
    public String token;
    public String type;
    public UserInfo userInfo = new UserInfo();

    /* loaded from: classes3.dex */
    public class UserInfo implements Serializable {
        public String bduss;
        public String strEmail;
        public String strMobile;

        public UserInfo() {
        }
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void parserJson(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("info");
            if (optJSONObject == null) {
                return;
            }
            parserJson(optJSONObject.optJSONObject(AccountAccessActivityConfig.KEY_ACCESS_STATE));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.type = jSONObject.optString("type");
            this.token = jSONObject.optString("token");
            JSONObject jSONObject2 = jSONObject.getJSONObject(TableDefine.DB_TABLE_USERINFO);
            if (jSONObject2 == null) {
                return;
            }
            this.userInfo.strMobile = jSONObject2.optString("strMobile");
            this.userInfo.strEmail = jSONObject2.optString("strEmail");
            this.userInfo.bduss = jSONObject2.optString("bduss");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
