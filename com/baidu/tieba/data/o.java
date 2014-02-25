package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private String a;
    private String b;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("img");
        this.b = jSONObject.optString("link");
    }
}
