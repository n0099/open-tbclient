package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private String Ea;

    public String getClientId() {
        return this.Ea;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Ea = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
