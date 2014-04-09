package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class j {
    private String a;
    private String b;

    public final void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("img");
        this.b = jSONObject.optString("link");
    }
}
