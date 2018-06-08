package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aAE;

    public boolean BD() {
        return this.aAE == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAE = jSONObject.optInt("agree_icon", 0);
        }
    }
}
