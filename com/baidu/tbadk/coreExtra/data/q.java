package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class q {
    private String MS;

    public String getClientId() {
        return this.MS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.MS = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
