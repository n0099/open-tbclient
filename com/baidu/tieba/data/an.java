package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private int f1004a = 0;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int c = 0;

    public int a() {
        return this.f1004a;
    }

    public void a(int i) {
        this.f1004a = i;
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

    public int d() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public void e(int i) {
        this.f = i;
    }

    public int f() {
        return this.f;
    }

    public void f(int i) {
        this.g = i;
    }

    public int g() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1004a = jSONObject.optInt("total_page", 0);
                this.b = jSONObject.optInt("total_num", 0);
                this.c = jSONObject.optInt("total_count", 0);
                this.d = jSONObject.optInt("current_page", 0);
                this.e = jSONObject.optInt("page_size", 0);
                this.f = jSONObject.optInt("has_more", 0);
                this.g = jSONObject.optInt("has_prev", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.av.b("PageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
