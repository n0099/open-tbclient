package com.baidu.tieba.discover.memberprivilege;

import org.json.JSONObject;
/* loaded from: classes.dex */
class k {
    public String a;
    public String b;
    public j c = new j();

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("name");
            this.b = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            this.c.a(jSONObject.optJSONObject("pay_member_info"));
        }
    }
}
