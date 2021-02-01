package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int fqI;
    private n fqJ;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.fqI = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.fqJ = new n();
            this.fqJ.parserData(optJSONObject2);
        }
    }

    public int bwo() {
        return this.fqI;
    }

    public n bwp() {
        return this.fqJ;
    }
}
