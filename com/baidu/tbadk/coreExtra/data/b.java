package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int asx;

    public boolean ye() {
        return this.asx == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.asx = jSONObject.optInt("agree_icon", 0);
        }
    }
}
