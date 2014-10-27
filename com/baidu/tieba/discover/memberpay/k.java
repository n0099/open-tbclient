package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    String alg;
    long aoG;
    long aoH;
    i aoI = new i();
    long mId;
    String mName;
    String mPortrait;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optLong("id");
            this.mName = jSONObject.optString("name");
            this.alg = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
            this.mPortrait = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.aoG = jSONObject.optLong("user_type");
            this.aoH = jSONObject.optLong("is_verify");
            this.aoI.parseJson(jSONObject.optJSONObject("pay_member_info"));
        }
    }
}
