package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String Nd;

    public String getClientId() {
        return this.Nd;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Nd = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
