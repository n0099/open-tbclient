package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class y {
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
    private ax m = new ax();

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final int d() {
        return this.g;
    }

    public final int e() {
        return this.h;
    }

    public final int f() {
        return this.b;
    }

    public final void a(int i) {
        this.b = 1;
    }

    public final long g() {
        return this.k;
    }

    public final void b(int i) {
        this.e = 1;
    }

    public final int h() {
        return this.e;
    }

    public final void c(int i) {
        this.f = i;
    }

    public final int i() {
        return this.f;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
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
                com.baidu.adp.lib.util.e.b("FrsStarData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final ax j() {
        return this.m;
    }
}
