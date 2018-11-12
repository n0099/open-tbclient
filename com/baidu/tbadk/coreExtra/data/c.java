package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aJN;

    public boolean Fm() {
        return this.aJN == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJN = jSONObject.optInt("agree_icon", 0);
        }
    }
}
