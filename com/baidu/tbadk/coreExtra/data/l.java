package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {
    private int eAj;
    private m eAk;

    public void cY(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.eAj = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.eAk = new m();
            this.eAk.cY(optJSONObject2);
        }
    }

    public int bmI() {
        return this.eAj;
    }

    public m bmJ() {
        return this.eAk;
    }
}
