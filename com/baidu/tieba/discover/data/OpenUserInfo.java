package com.baidu.tieba.discover.data;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OpenUserInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private String openID;
    private String userName;

    public String getOpenID() {
        return this.openID;
    }

    public void setOpenID(String str) {
        this.openID = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.openID = jSONObject.optString("openid");
            JSONObject optJSONObject = jSONObject.optJSONObject("userData");
            if (optJSONObject != null) {
                this.userName = optJSONObject.optString("name");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toJson() {
        try {
            if (TextUtils.isEmpty(this.openID) || TextUtils.isEmpty(this.userName)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("openid", this.openID);
            jSONObject.put("userName", this.userName);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void parseLocalJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.openID = jSONObject.optString("openid");
                this.userName = jSONObject.optString("userName");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
