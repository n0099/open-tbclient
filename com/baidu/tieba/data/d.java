package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String lP;

    public String getClientId() {
        return this.lP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lP = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
