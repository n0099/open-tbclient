package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private String a = null;
    private int b = 0;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.b = jSONObject.optInt("class_id", 0);
            this.a = jSONObject.optString("class_name");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("GoodData", "parserJson", "error = " + e.getMessage());
        }
    }

    public int b() {
        return this.b;
    }
}
