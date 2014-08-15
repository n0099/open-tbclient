package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    String a;
    long b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("name");
            this.b = jSONObject.optLong("num");
        }
    }
}
