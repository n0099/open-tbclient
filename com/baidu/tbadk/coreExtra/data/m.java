package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int fsj;
    private n fsk;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.fsj = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.fsk = new n();
            this.fsk.parserData(optJSONObject2);
        }
    }

    public int bwr() {
        return this.fsj;
    }

    public n bws() {
        return this.fsk;
    }
}
