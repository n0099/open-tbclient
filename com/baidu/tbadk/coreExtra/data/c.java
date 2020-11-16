package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int fbm;

    public boolean btC() {
        return this.fbm == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fbm = jSONObject.optInt("agree_icon", 0);
        }
    }
}
