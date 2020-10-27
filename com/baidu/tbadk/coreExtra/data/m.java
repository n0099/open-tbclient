package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int eWV;
    private n eWW;

    public void dl(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.eWV = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.eWW = new n();
            this.eWW.dl(optJSONObject2);
        }
    }

    public int bsf() {
        return this.eWV;
    }

    public n bsg() {
        return this.eWW;
    }
}
