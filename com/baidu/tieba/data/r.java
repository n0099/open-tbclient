package com.baidu.tieba.data;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private boolean b;
    private int d;
    private int e;
    private String f;
    private long c = 0;
    private af a = new af();

    public r() {
        this.b = true;
        this.b = false;
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.b = false;
            return;
        }
        try {
            a(new JSONObject(str));
            this.b = true;
        } catch (Exception e) {
            this.b = false;
            com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.d = jSONObject.optInt("msign_valid");
            this.e = jSONObject.optInt("msign_level");
            this.f = jSONObject.optString("msign_text");
            JSONArray optJSONArray = jSONObject.optJSONArray("like_forum");
            this.a.a(this.e);
            this.a.a(optJSONArray);
            this.c = jSONObject.optLong("time");
        } catch (Exception e) {
            this.b = false;
            com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public af d() {
        return this.a;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean e() {
        return this.b;
    }

    public boolean f() {
        return System.currentTimeMillis() / h.f.longValue() == (this.c * 1000) / h.f.longValue();
    }

    public boolean g() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }
}
