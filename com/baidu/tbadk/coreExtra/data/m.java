package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int ftb;
    private n ftc;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.ftb = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.ftc = new n();
            this.ftc.parserData(optJSONObject2);
        }
    }

    public int bzP() {
        return this.ftb;
    }

    public n bzQ() {
        return this.ftc;
    }
}
