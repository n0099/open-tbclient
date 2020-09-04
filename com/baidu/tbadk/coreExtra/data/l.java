package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private int eAn;
    private m eAo;

    public void cY(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.eAn = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.eAo = new m();
            this.eAo.cY(optJSONObject2);
        }
    }

    public int bmI() {
        return this.eAn;
    }

    public m bmJ() {
        return this.eAo;
    }
}
