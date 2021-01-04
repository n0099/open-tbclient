package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private String Oo;

    public String getClientId() {
        return this.Oo;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Oo = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
