package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int a = 0;
    private int b = 0;
    private String c = null;
    private String d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private long k = 0;
    private long l = 0;

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("has_frs_star", 0);
            if (this.a == 1) {
                this.c = jSONObject.optString("top", "");
                this.d = jSONObject.optString("head", "");
                JSONObject optJSONObject = jSONObject.optJSONObject("fans");
                this.e = optJSONObject.optInt("is_get", 0);
                this.f = optJSONObject.optInt("num", 0);
                this.b = optJSONObject.optInt("open", 0);
                this.k = optJSONObject.optLong("left_time", 0L);
                this.l = this.k;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_size");
                this.g = optJSONObject2.optInt("width", 0);
                this.h = optJSONObject2.optInt("height", 0);
                JSONObject optJSONObject3 = jSONObject.optJSONObject("head_size");
                this.i = optJSONObject3.optInt("width", 0);
                this.j = optJSONObject3.optInt("height", 0);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("FrsStarData", "parserJson", "error = " + e.getMessage());
        }
    }

    public String b() {
        return this.c;
    }

    public void b(int i) {
        this.e = i;
    }

    public String c() {
        return this.d;
    }

    public void c(int i) {
        this.f = i;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public int h() {
        return this.b;
    }

    public long i() {
        return this.k;
    }

    public int j() {
        return this.e;
    }

    public int k() {
        return this.f;
    }
}
