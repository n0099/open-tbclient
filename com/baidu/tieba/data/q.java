package com.baidu.tieba.data;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public az f1021a;
    public bo b;
    private aj c;
    private com.baidu.tieba.square.g d;
    private boolean e;
    private long f = 0;

    public q() {
        this.e = true;
        this.e = true;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.e = false;
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.e = false;
            com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("like_forum");
            JSONObject optJSONObject = jSONObject.optJSONObject("recommend");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("topic");
            this.f1021a = new az(optJSONObject);
            this.b = new bo(optJSONArray2);
            this.c = new aj();
            this.c.a(optJSONArray);
            this.d = new com.baidu.tieba.square.g();
            this.d.b(jSONObject);
            this.f = jSONObject.optLong("time");
        } catch (Exception e) {
            this.e = false;
            com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public aj a() {
        return this.c;
    }

    public com.baidu.tieba.square.g b() {
        return this.d;
    }

    public az c() {
        return this.f1021a;
    }

    public bo d() {
        return this.b;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return System.currentTimeMillis() / g.f.longValue() == (this.f * 1000) / g.f.longValue();
    }

    public boolean g() {
        boolean z = false;
        if (this.e) {
            if (this.f1021a == null || this.b == null || this.c == null || this.d == null) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
