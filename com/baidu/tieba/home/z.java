package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private int f1470a;
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

    public int a() {
        return this.f1470a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public boolean i() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
        this.d = 1;
    }

    public boolean j() {
        return this.k;
    }

    public void b(boolean z) {
        this.k = z;
        this.d = 0;
    }

    public boolean k() {
        return this.l;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public boolean l() {
        return this.m;
    }

    public void d(boolean z) {
        this.m = z;
    }

    public int m() {
        return this.n;
    }

    public void d(int i) {
        this.n = i;
    }

    public String n() {
        return this.o;
    }

    public void a(String str) {
        this.o = str;
    }

    public boolean o() {
        return this.j;
    }

    public void e(boolean z) {
        this.j = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1470a = jSONObject.optInt("forum_id");
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
                com.baidu.tieba.util.bg.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
