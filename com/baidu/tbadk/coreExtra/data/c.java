package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dhz;

    public boolean aGK() {
        return this.dhz == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dhz = jSONObject.optInt("agree_icon", 0);
        }
    }
}
