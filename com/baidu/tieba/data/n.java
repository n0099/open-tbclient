package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private boolean d;
    private boolean e;
    private int g;
    private int h;
    private String i;
    private com.baidu.tieba.square.at c = new com.baidu.tieba.square.at();
    private long f = 0;
    private y a = new y();
    private am b = new am();

    public boolean a() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public n() {
        this.e = true;
        this.e = false;
    }

    public am b() {
        return this.b;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.e = false;
            return;
        }
        try {
            a(new JSONObject(str));
            this.e = true;
        } catch (Exception e) {
            this.e = false;
            BdLog.e(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.g = jSONObject.optInt("msign_valid");
            this.h = jSONObject.optInt("msign_level");
            this.i = jSONObject.optString("msign_text");
            JSONArray optJSONArray = jSONObject.optJSONArray("like_forum");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("new_recommend");
            JSONObject optJSONObject = jSONObject.optJSONObject("banner");
            this.a.a(this.h);
            this.a.a(optJSONArray);
            this.b.a(optJSONArray2);
            this.f = jSONObject.optLong("time");
            b(optJSONObject);
        } catch (Exception e) {
            this.e = false;
            BdLog.e(getClass().getName(), "parserJson", e.toString());
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c.a(jSONObject.optString("pic_url", ""));
                this.c.b(jSONObject.optString("link", ""));
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "BannerData", e.toString());
            }
        }
    }

    public com.baidu.tieba.square.at f() {
        return this.c;
    }

    public y g() {
        return this.a;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return System.currentTimeMillis() / d.e.longValue() == (this.f * 1000) / d.e.longValue();
    }

    public boolean j() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }
}
