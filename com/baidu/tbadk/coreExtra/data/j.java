package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private String checkUrl;

    public String uH() {
        return this.checkUrl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.checkUrl = jSONObject.optString("checkurl", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
