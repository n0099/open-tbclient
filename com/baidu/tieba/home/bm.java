package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bm {
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private n h = new n();

    public int a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public n e() {
        return this.h;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.h.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("forum_id");
                this.b = jSONObject.optString("forum_name");
                this.c = jSONObject.optInt("signed");
                this.d = jSONObject.optInt("is_on");
                this.e = jSONObject.optInt("is_filter");
                this.f = jSONObject.optInt("sign_day_count");
                this.g = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
