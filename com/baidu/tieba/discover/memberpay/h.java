package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    String a;
    String b;
    String c;
    long d;
    long e;
    long f;
    long g;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("productId");
            this.b = jSONObject.optString("title");
            this.c = jSONObject.optString("desc");
            this.d = jSONObject.optLong(PayActivityConfig.PROPS_ID);
            this.e = jSONObject.optLong("money");
            this.g = jSONObject.optLong("months");
            this.f = jSONObject.optLong("default");
        }
    }
}
