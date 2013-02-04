package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class au extends ah {
    private int i;
    private String j = null;
    private String a = null;
    private String c = null;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 1;
    private String h = null;

    public au() {
        b(0);
    }

    public void a(int i) {
        this.g = i;
    }

    @Override // com.baidu.tieba.a.ah
    public void a(JSONObject jSONObject) {
        try {
            super.a(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("ip");
            this.c = jSONObject.optString("BDUSS");
            this.b = jSONObject.optInt("level_id", 0);
            this.d = jSONObject.optInt("fans_num");
            this.e = jSONObject.optInt("concern_num");
            this.g = jSONObject.optInt("sex", 1);
            this.f = jSONObject.optInt("my_like_num");
            this.h = jSONObject.optString("intro");
            this.i = jSONObject.optInt("has_concerned");
            this.j = jSONObject.optString("passwd");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(int i) {
        this.i = i;
    }

    @Override // com.baidu.tieba.a.ah
    public void d(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.h = str;
    }

    public int f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    public String h() {
        return this.h;
    }

    public int i() {
        return this.g;
    }

    public String j() {
        return this.c;
    }

    public int k() {
        return this.b;
    }

    public int l() {
        return this.f;
    }

    public int m() {
        return this.i;
    }
}
