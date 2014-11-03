package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class f {
    public c apD = new c();
    public e apE = new e();
    public String mName;
    public String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mName = jSONObject.optString("name");
            this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.apD.parseJson(jSONObject.optJSONObject("pay_member_info"));
            this.apE.parseJson(jSONObject.optJSONObject("Parr_scores"));
        }
    }
}
