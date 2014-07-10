package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public String a() {
        return this.a;
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
        return this.g;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.h;
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("link");
        this.b = jSONObject.optString("title");
        this.c = jSONObject.optString("abstract");
        this.d = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        this.e = jSONObject.optString("img");
        this.f = jSONObject.optString("post_type");
        this.g = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME);
        this.h = jSONObject.optString("reply_num");
        this.i = jSONObject.optString("proper");
    }
}
