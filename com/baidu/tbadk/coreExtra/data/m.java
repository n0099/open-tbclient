package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    private int fbS;
    private n fbT;

    public void dl(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("common");
        if (optJSONObject != null) {
            this.fbS = optJSONObject.optInt("version");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("special");
        if (optJSONObject2 != null) {
            this.fbT = new n();
            this.fbT.dl(optJSONObject2);
        }
    }

    public int btV() {
        return this.fbS;
    }

    public n btW() {
        return this.fbT;
    }
}
