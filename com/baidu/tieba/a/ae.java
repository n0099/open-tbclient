package com.baidu.tieba.a;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae implements Serializable {
    private String a;
    private String d;
    private String l;
    private String m;
    private String n;
    private String b = null;
    private int c = 0;
    private long e = 0;
    private String h = null;
    private boolean f = true;
    private boolean g = false;
    private String i = null;
    private int j = 0;
    private int k = 0;

    public String a() {
        return this.i;
    }

    public void a(String str) {
        this.i = str;
    }

    public int b() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public void b(int i) {
        this.k = i;
    }

    public String c() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void c(String str) {
        this.h = str;
    }

    public String d() {
        return this.h;
    }

    public void a(Boolean bool) {
        this.f = bool.booleanValue();
    }

    public Boolean e() {
        return Boolean.valueOf(this.f);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean f() {
        return this.g;
    }

    public void d(String str) {
        this.d = str;
    }

    public String g() {
        return this.d;
    }

    public void e(String str) {
        this.a = str;
    }

    public String h() {
        return this.a;
    }

    public void f(String str) {
        this.l = str;
    }

    public void g(String str) {
        this.m = str;
    }

    public void h(String str) {
        this.n = str;
    }

    public JSONObject i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.n);
            jSONObject.put("pid", this.d);
            if (this.g) {
                jSONObject.put("status", "1");
            } else if (!this.f) {
                jSONObject.put("status", "2");
            } else {
                jSONObject.put("status", "0");
            }
            return jSONObject;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "toJson", e.toString());
            return null;
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.n = jSONObject.optString("thread_id");
            this.d = jSONObject.optString("mark_pid");
            this.m = jSONObject.optString("forum_name");
            this.h = jSONObject.optString("title");
            this.i = jSONObject.optJSONObject("author").optString("name_show");
            this.b = this.n;
            this.j = jSONObject.optInt("reply_num");
            int optInt = jSONObject.optInt("mark_status");
            if (optInt == 1) {
                this.g = true;
            } else if (optInt == 2) {
                this.f = false;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "fromJson", e.toString());
        }
    }
}
