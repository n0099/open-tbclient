package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bd extends ai {
    private int i;
    private String j = null;
    private int k = 0;
    private String a = null;
    private String c = null;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 1;
    private String h = null;

    public bd() {
        c(0);
    }

    public int f() {
        return this.k;
    }

    public String g() {
        return this.j;
    }

    @Override // com.baidu.tieba.a.ai
    public void e(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.a.ai
    public void a(JSONObject jSONObject) {
        try {
            super.a(jSONObject);
            if (jSONObject != null) {
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
                this.k = jSONObject.optInt("is_like", 0);
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PostData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void f(String str) {
        this.h = str;
    }

    public String h() {
        return this.h;
    }

    public void b(int i) {
        this.g = i;
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

    public void c(int i) {
        this.i = i;
    }

    public int l() {
        return this.i;
    }
}
