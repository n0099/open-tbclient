package com.baidu.tieba.data;

import com.baidu.tieba.square.at;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class n {
    private boolean c;
    private boolean d;
    private int f;
    private int g;
    private String h;
    private at b = new at();
    private long e = 0;
    private y a = new y();

    public final boolean a() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = true;
    }

    public n() {
        this.d = true;
        this.d = false;
    }

    public final int b() {
        return this.f;
    }

    public final int c() {
        return this.g;
    }

    public final String d() {
        return this.h;
    }

    public final void a(String str) {
        if (str == null || str.length() <= 0) {
            this.d = false;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f = jSONObject.optInt("msign_valid");
                this.g = jSONObject.optInt("msign_level");
                this.h = jSONObject.optString("msign_text");
                JSONArray optJSONArray = jSONObject.optJSONArray("like_forum");
                JSONObject optJSONObject = jSONObject.optJSONObject("banner");
                this.a.a(this.g);
                this.a.a(optJSONArray);
                this.e = jSONObject.optLong("time");
                a(optJSONObject);
            } catch (Exception e) {
                this.d = false;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.toString());
            }
            this.d = true;
        } catch (Exception e2) {
            this.d = false;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e2.toString());
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b.a(jSONObject.optString("pic_url", ""));
                this.b.b(jSONObject.optString("link", ""));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "BannerData", e.toString());
            }
        }
    }

    public final at e() {
        return this.b;
    }

    public final y f() {
        return this.a;
    }

    public final void b(boolean z) {
        this.d = true;
    }

    public final boolean g() {
        return this.d;
    }

    public final boolean h() {
        return System.currentTimeMillis() / d.e.longValue() == (this.e * 1000) / d.e.longValue();
    }

    public final boolean i() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }
}
