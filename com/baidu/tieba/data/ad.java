package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private String a = null;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("name");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
