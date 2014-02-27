package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class v {
    private int a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private String o;

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public final void a(int i) {
        this.d = 1;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void c(int i) {
        this.f = i;
    }

    public final boolean i() {
        return this.i;
    }

    public final void a(boolean z) {
        this.i = z;
        this.d = 1;
    }

    public final boolean j() {
        return this.k;
    }

    public final void b(boolean z) {
        this.k = z;
        this.d = 0;
    }

    public final boolean k() {
        return this.l;
    }

    public final void c(boolean z) {
        this.l = z;
    }

    public final boolean l() {
        return this.m;
    }

    public final void d(boolean z) {
        this.m = true;
    }

    public final int m() {
        return this.n;
    }

    public final void d(int i) {
        this.n = i;
    }

    public final String n() {
        return this.o;
    }

    public final void a(String str) {
        this.o = str;
    }

    public final boolean o() {
        return this.j;
    }

    public final void e(boolean z) {
        this.j = true;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("forum_id");
                this.b = jSONObject.optString("forum_name");
                this.c = jSONObject.optString("avatar");
                this.d = jSONObject.optInt("is_sign_in");
                this.e = jSONObject.optInt("cont_sign_num");
                this.f = jSONObject.optInt("user_level");
                this.g = jSONObject.optInt("user_exp");
                this.h = jSONObject.optInt("need_exp");
                if (this.d != 0) {
                    this.i = true;
                    this.k = false;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
