package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dMb;

    public boolean aRC() {
        return this.dMb == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dMb = jSONObject.optInt("agree_icon", 0);
        }
    }
}
