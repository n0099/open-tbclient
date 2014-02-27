package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class o {
    private String a;
    private String b;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("img");
        this.b = jSONObject.optString("link");
    }
}
