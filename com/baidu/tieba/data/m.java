package com.baidu.tieba.data;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public aq f793a;
    public bc b;
    private ab c;
    private com.baidu.tieba.square.f d;
    private boolean e;
    private long f = 0;

    public m() {
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
            com.baidu.tieba.util.z.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("like_forum");
            JSONObject optJSONObject = jSONObject.optJSONObject("recommend");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("topic");
            this.f793a = new aq(optJSONObject);
            this.b = new bc(optJSONArray2);
            this.c = new ab();
            this.c.a(optJSONArray);
            this.d = new com.baidu.tieba.square.f();
            this.d.b(jSONObject);
            this.f = jSONObject.optLong("time");
        } catch (Exception e) {
            this.e = false;
            com.baidu.tieba.util.z.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public ab a() {
        return this.c;
    }

    public com.baidu.tieba.square.f b() {
        return this.d;
    }

    public aq c() {
        return this.f793a;
    }

    public bc d() {
        return this.b;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return System.currentTimeMillis() / g.e.longValue() == (this.f * 1000) / g.e.longValue();
    }

    public boolean g() {
        boolean z = false;
        if (this.e) {
            if (this.f793a == null || this.b == null || this.c == null || this.d == null) {
                z = true;
            }
            return z;
        }
        return true;
    }
}
