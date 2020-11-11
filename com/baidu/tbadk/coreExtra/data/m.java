package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int fcL;
    private n fcM;

    public void dr(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.fcL = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.fcM = new n();
            this.fcM.dr(optJSONObject2);
        }
    }

    public int buF() {
        return this.fcL;
    }

    public n buG() {
        return this.fcM;
    }
}
