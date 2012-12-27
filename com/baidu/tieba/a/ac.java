package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ac {
    private String a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = null;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("id");
            this.b = jSONObject.optString("name");
            this.c = jSONObject.optInt("member_count", 0);
            this.d = jSONObject.optInt("is_like", 0);
            this.e = this.d;
            this.f = jSONObject.optInt("level_id", 1);
            this.g = jSONObject.optInt("favo_type", 0);
            this.h = jSONObject.optString("desc");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("LikeForumData", "parserJson", "error = " + e.getMessage());
        }
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.f = i;
    }

    public int c() {
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

    public String h() {
        return this.h;
    }
}
