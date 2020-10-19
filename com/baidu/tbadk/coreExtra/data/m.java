package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private n eOA;
    private int eOz;

    public void di(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.eOz = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.eOA = new n();
            this.eOA.di(optJSONObject2);
        }
    }

    public int bqm() {
        return this.eOz;
    }

    public n bqn() {
        return this.eOA;
    }
}
