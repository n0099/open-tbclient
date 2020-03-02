package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dlG;

    public boolean aJa() {
        return this.dlG == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dlG = jSONObject.optInt("agree_icon", 0);
        }
    }
}
