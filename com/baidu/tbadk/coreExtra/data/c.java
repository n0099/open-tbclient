package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dmg;

    public boolean aJf() {
        return this.dmg == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dmg = jSONObject.optInt("agree_icon", 0);
        }
    }
}
