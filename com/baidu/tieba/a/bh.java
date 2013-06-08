package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bh {
    private String a = null;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int c = 0;

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.d = jSONObject.optInt("width", 0);
                this.e = jSONObject.optInt("height", 0);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
