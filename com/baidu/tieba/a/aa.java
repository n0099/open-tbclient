package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {
    private String a = null;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("name");
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
