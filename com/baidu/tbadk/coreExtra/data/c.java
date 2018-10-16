package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aIX;

    public boolean Fb() {
        return this.aIX == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIX = jSONObject.optInt("agree_icon", 0);
        }
    }
}
