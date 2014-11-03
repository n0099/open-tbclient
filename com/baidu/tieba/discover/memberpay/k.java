package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    String alq;
    long aoP;
    long aoQ;
    i aoR = new i();
    long mId;
    String mName;
    String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optLong("id");
            this.mName = jSONObject.optString("name");
            this.alq = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
            this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.aoP = jSONObject.optLong("user_type");
            this.aoQ = jSONObject.optLong("is_verify");
            this.aoR.parseJson(jSONObject.optJSONObject("pay_member_info"));
        }
    }
}
