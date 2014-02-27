package com.baidu.tieba.data;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class s {
    private boolean b;
    private boolean c;
    private int e;
    private int f;
    private String g;
    private long d = 0;
    private ae a = new ae();

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = true;
    }

    public s() {
        this.c = true;
        this.c = false;
    }

    public final int b() {
        return this.e;
    }

    public final int c() {
        return this.f;
    }

    public final String d() {
        return this.g;
    }

    public final void a(String str) {
        if (str == null || str.length() <= 0) {
            this.c = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.toString());
            }
            this.c = true;
        } catch (Exception e2) {
            this.c = false;
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e2.toString());
        }
    }

    public final ae e() {
        return this.a;
    }

    public final void b(boolean z) {
        this.c = true;
    }

    public final boolean f() {
        return this.c;
    }

    public final boolean g() {
        return System.currentTimeMillis() / i.f.longValue() == (this.d * 1000) / i.f.longValue();
    }

    public final boolean h() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }
}
