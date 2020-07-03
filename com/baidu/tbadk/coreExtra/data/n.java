package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private String Mn;

    public String getClientId() {
        return this.Mn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Mn = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
