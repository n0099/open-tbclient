package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dhn;

    public boolean aGr() {
        return this.dhn == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dhn = jSONObject.optInt("agree_icon", 0);
        }
    }
}
