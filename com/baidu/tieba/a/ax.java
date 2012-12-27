package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ax {
    private String a = null;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int c = 0;

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("id");
            this.d = jSONObject.optInt("width", 0);
            this.e = jSONObject.optInt("height", 0);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
        }
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.c = i;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }
}
