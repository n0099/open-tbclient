package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int fjs;
    private n fjt;

    public void parserData(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.fjs = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.fjt = new n();
            this.fjt.parserData(optJSONObject2);
        }
    }

    public int bxv() {
        return this.fjs;
    }

    public n bxw() {
        return this.fjt;
    }
}
