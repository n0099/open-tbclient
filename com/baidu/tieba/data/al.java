package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class al {
    private int a = 0;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int c = 0;

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final int e() {
        return this.e;
    }

    public final void d(int i) {
        this.e = i;
    }

    public final void e(int i) {
        this.f = i;
    }

    public final int f() {
        return this.f;
    }

    public final void f(int i) {
        this.g = i;
    }

    public final int g() {
        return this.g;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("total_page", 0);
                this.b = jSONObject.optInt("total_num", 0);
                this.c = jSONObject.optInt("total_count", 0);
                this.d = jSONObject.optInt("current_page", 0);
                this.e = jSONObject.optInt("page_size", 0);
                this.f = jSONObject.optInt("has_more", 0);
                this.g = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("PageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
