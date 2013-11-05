package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private int f1179a = 0;
    private long b = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private MetaData i = new MetaData();
    private MetaData j = new MetaData();
    private int k;
    private String l;

    public int a() {
        return this.f1179a;
    }

    public long b() {
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
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public MetaData i() {
        return this.i;
    }

    public boolean j() {
        return this.k == 1;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1179a = jSONObject.optInt("type", 0);
                this.c = jSONObject.optString("title");
                this.b = jSONObject.optLong("time", 0L) * 1000;
                this.d = jSONObject.optString("fname");
                this.e = jSONObject.optString("content");
                this.f = jSONObject.optString("quote_content");
                this.g = jSONObject.optString("thread_id");
                this.h = jSONObject.optString("post_id");
                this.k = jSONObject.optInt("is_floor");
                this.l = jSONObject.optString("quote_pid");
                this.i.parserJson(jSONObject.optJSONObject("replyer"));
                this.j.parserJson(jSONObject.optJSONObject("quote_user"));
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("FeedData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
