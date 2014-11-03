package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public g aoF = new g();
    public e aoG = new e();

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoF.parseJson(jSONObject.optJSONObject("member"));
            this.aoG.parseJson(jSONObject.optJSONObject("adv_member"));
        }
    }
}
