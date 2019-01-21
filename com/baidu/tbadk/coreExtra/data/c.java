package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aNS;

    public boolean GE() {
        return this.aNS == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNS = jSONObject.optInt("agree_icon", 0);
        }
    }
}
