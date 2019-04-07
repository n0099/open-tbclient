package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bWu;

    public boolean afU() {
        return this.bWu == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bWu = jSONObject.optInt("agree_icon", 0);
        }
    }
}
