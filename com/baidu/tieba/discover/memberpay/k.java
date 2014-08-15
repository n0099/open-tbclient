package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    long a;
    String b;
    String c;
    String d;
    long e;
    long f;
    i g = new i();

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optLong("id");
            this.b = jSONObject.optString("name");
            this.c = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
            this.d = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.e = jSONObject.optLong("user_type");
            this.f = jSONObject.optLong("is_verify");
            this.g.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }
}
