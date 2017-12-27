package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int beU;

    public boolean Fd() {
        return this.beU == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.beU = jSONObject.optInt("agree_icon", 0);
        }
    }
}
