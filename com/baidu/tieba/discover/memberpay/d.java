package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public k aos = new k();
    public f aot = new f();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aos.parseJson(jSONObject.optJSONObject("user"));
            this.aot.parseJson(jSONObject.optJSONObject("goods_info"));
        }
    }
}
