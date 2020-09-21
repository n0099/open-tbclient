package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int eCs;
    private n eCt;

    public void db(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.eCs = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.eCt = new n();
            this.eCt.db(optJSONObject2);
        }
    }

    public int bnC() {
        return this.eCs;
    }

    public n bnD() {
        return this.eCt;
    }
}
