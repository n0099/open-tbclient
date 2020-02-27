package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dlF;

    public boolean aIY() {
        return this.dlF == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dlF = jSONObject.optInt("agree_icon", 0);
        }
    }
}
