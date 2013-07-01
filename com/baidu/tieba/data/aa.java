package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private String f751a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private int f = 0;
    private String e = null;

    public void a(String str) {
        this.f751a = str;
    }

    public String a() {
        return this.f751a;
    }

    public void b(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    public void b(int i) {
        this.c = i;
    }

    public int d() {
        return this.c;
    }

    public void c(String str) {
        this.e = str;
    }

    public String e() {
        return this.e;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f751a = jSONObject.optString("forum_id");
                this.b = jSONObject.optString("forum_name");
                c(jSONObject.optInt("is_like", 0));
                this.d = jSONObject.optInt("is_sign", 0);
                this.c = jSONObject.optInt("level_id", 0);
                this.e = jSONObject.optString("avatar", "");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("BrowseForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void c(int i) {
        this.f = i;
    }

    public int f() {
        return this.f;
    }
}
