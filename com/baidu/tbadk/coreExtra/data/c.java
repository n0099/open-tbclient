package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int ctB;

    public boolean aoP() {
        return this.ctB == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ctB = jSONObject.optInt("agree_icon", 0);
        }
    }
}
