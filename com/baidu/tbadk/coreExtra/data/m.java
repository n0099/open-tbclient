package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String sA;

    public String getClientId() {
        return this.sA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.sA = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
