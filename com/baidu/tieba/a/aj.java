package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public int a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("total_page", 0);
            this.b = jSONObject.optInt("total_num", 0);
            this.c = jSONObject.optInt("current_page", 0);
            this.d = jSONObject.optInt("page_size", 0);
            this.e = jSONObject.optInt("has_more", 0);
            this.f = jSONObject.optInt("has_prev", 0);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }
}
