package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aNR;

    public boolean GE() {
        return this.aNR == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNR = jSONObject.optInt("agree_icon", 0);
        }
    }
}
