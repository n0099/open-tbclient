package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public g aow = new g();
    public e aox = new e();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aow.parseJson(jSONObject.optJSONObject("member"));
            this.aox.parseJson(jSONObject.optJSONObject("adv_member"));
        }
    }
}
