package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String a = null;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("client_id");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
