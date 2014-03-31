package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class l {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return this.g;
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.h;
    }

    public final void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("link");
        this.b = jSONObject.optString("title");
        this.c = jSONObject.optString("abstract");
        this.d = jSONObject.optString("forum_name");
        this.e = jSONObject.optString("img");
        this.f = jSONObject.optString("post_type");
        this.g = jSONObject.optString("user_name");
        this.h = jSONObject.optString("reply_num");
        this.i = jSONObject.optString("proper");
    }
}
