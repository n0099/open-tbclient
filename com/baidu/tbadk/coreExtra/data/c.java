package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int eaw;

    public boolean aXH() {
        return this.eaw == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eaw = jSONObject.optInt("agree_icon", 0);
        }
    }
}
