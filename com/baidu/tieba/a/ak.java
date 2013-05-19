package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(int i) {
        this.e = i;
    }

    public int e() {
        return this.e;
    }

    public void f(int i) {
        this.f = i;
    }

    public int f() {
        return this.f;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("total_page", 0);
                this.b = jSONObject.optInt("total_num", 0);
                this.c = jSONObject.optInt("current_page", 0);
                this.d = jSONObject.optInt("page_size", 0);
                this.e = jSONObject.optInt("has_more", 0);
                this.f = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b("PageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
