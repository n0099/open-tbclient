package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class f {
    public c apu = new c();
    public e apv = new e();
    public String mName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mName = jSONObject.optString("name");
            this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.apu.parseJson(jSONObject.optJSONObject("pay_member_info"));
            this.apv.parseJson(jSONObject.optJSONObject("Parr_scores"));
        }
    }
}
