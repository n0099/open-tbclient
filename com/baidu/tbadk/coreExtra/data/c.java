package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dMf;

    public boolean aRz() {
        return this.dMf == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dMf = jSONObject.optInt("agree_icon", 0);
        }
    }
}
