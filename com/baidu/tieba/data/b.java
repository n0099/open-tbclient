package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int a;
    private String b;
    private String c;
    private String d;

    public void a(JSONObject jSONObject) {
        try {
            this.b = jSONObject.optString("icon_url");
            this.c = jSONObject.optString("icon_link");
            this.d = jSONObject.optString("content");
            this.a = jSONObject.optInt("tail_type");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }
}
