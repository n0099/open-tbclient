package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public k a = new k();
    public f b = new f();

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a.a(jSONObject.optJSONObject("user"));
            this.b.a(jSONObject.optJSONObject("goods_info"));
        }
    }
}
