package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private int f979a;
    private int b;
    private int c;
    private int d;
    private String e;
    private int f;
    private int g;

    public ag() {
        b(0);
        c(0);
        d(0);
        this.d = 0;
        b("");
        e(0);
        f(0);
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        if (i >= 0) {
            this.d = i;
        }
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("info"));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                b(jSONObject.optInt("is_like", 0));
                c(jSONObject.optInt("is_black", 0));
                d(jSONObject.optInt("like_num", 0));
                this.d = jSONObject.optInt("level_id", 0);
                b(jSONObject.optString("level_name", ""));
                f(jSONObject.optInt("levelup_score", 0));
                e(jSONObject.optInt("cur_score", 0));
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void b(int i) {
        this.f979a = i;
    }

    public int b() {
        return this.f979a;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.e;
    }

    public void e(int i) {
        this.f = i;
    }

    public int d() {
        return this.f;
    }

    public void f(int i) {
        this.g = i;
    }

    public int e() {
        return this.g;
    }
}
