package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private String f1204a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public String a() {
        return this.f1204a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.f;
    }

    public String h() {
        return this.h;
    }

    public void a(JSONObject jSONObject) {
        this.f1204a = jSONObject.optString("link");
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
