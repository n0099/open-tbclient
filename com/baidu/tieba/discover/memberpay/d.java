package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public k aoB = new k();
    public f aoC = new f();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoB.parseJson(jSONObject.optJSONObject("user"));
            this.aoC.parseJson(jSONObject.optJSONObject("goods_info"));
        }
    }
}
