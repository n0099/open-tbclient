package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bWv;

    public boolean afU() {
        return this.bWv == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bWv = jSONObject.optInt("agree_icon", 0);
        }
    }
}
