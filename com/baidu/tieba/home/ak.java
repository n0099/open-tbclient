package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ak {
    private int a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private q h = new q();

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.f;
    }

    public final int d() {
        return this.g;
    }

    public final q e() {
        return this.h;
    }

    public final void a(JSONObject jSONObject) {
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
