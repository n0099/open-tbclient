package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public g a = new g();
    public e b = new e();

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a.a(jSONObject.optJSONObject("member"));
            this.b.a(jSONObject.optJSONObject("adv_member"));
        }
    }
}
