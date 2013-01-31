package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private String a = null;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("client_id");
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
