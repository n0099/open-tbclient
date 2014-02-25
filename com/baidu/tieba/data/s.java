package com.baidu.tieba.data;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private boolean b;
    private boolean c;
    private int e;
    private int f;
    private String g;
    private long d = 0;
    private ae a = new ae();

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public s() {
        this.c = true;
        this.c = false;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.c = false;
            return;
        }
        try {
            a(new JSONObject(str));
            this.c = true;
        } catch (Exception e) {
            this.c = false;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.e = jSONObject.optInt("msign_valid");
            this.f = jSONObject.optInt("msign_level");
            this.g = jSONObject.optString("msign_text");
            JSONArray optJSONArray = jSONObject.optJSONArray("like_forum");
            this.a.a(this.f);
            this.a.a(optJSONArray);
            this.d = jSONObject.optLong("time");
        } catch (Exception e) {
            this.c = false;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public ae e() {
        return this.a;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return System.currentTimeMillis() / i.f.longValue() == (this.d * 1000) / i.f.longValue();
    }

    public boolean h() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }
}
