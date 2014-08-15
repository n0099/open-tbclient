package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private boolean d;
    private boolean e;
    private int g;
    private int h;
    private String i;
    private com.baidu.tieba.square.ap c = new com.baidu.tieba.square.ap();
    private long f = 0;
    private aa a = new aa();
    private as b = new as();

    public boolean a() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public o() {
        this.e = true;
        this.e = false;
    }

    public as b() {
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
            BdLog.detailException(e);
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
            BdLog.detailException(e);
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c.a(jSONObject.optString("pic_url", ""));
                this.c.b(jSONObject.optString("link", ""));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public com.baidu.tieba.square.ap f() {
        return this.c;
    }

    public aa g() {
        return this.a;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return System.currentTimeMillis() / e.e.longValue() == (this.f * 1000) / e.e.longValue();
    }

    public boolean j() {
        boolean z = false;
        if (this.e) {
            if (this.a == null || this.a.a() == null || this.a.a().size() < 1) {
                z = true;
            }
            return z;
        }
        return true;
    }

    public boolean k() {
        if (this.a != null) {
            return this.a.b();
        }
        return false;
    }
}
