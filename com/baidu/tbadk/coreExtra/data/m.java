package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int foq;

    /* renamed from: for  reason: not valid java name */
    private n f3for;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.foq = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.f3for = new n();
            this.f3for.parserData(optJSONObject2);
        }
    }

    public int bvW() {
        return this.foq;
    }

    public n bvX() {
        return this.f3for;
    }
}
