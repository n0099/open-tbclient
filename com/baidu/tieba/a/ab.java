package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private String g = null;
    private String h = null;

    public void a(int i) {
        this.f = i;
    }

    public int c() {
        return this.f;
    }

    public void b(int i) {
        this.a = i;
    }

    public int d() {
        return this.a;
    }

    public void c(int i) {
        this.b = i;
    }

    public int e() {
        return this.b;
    }

    public void d(int i) {
        this.c = i;
    }

    public int f() {
        return this.c;
    }

    public void e(int i) {
        this.d = i;
    }

    public int g() {
        return this.d;
    }

    public void f(int i) {
        this.e = i;
    }

    public int h() {
        return this.e;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.g = jSONObject.optString("tag_name");
                this.h = jSONObject.optString("tag_id");
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b("LabelSmallBallData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
