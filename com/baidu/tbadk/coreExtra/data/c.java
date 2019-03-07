package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bWr;

    public boolean afX() {
        return this.bWr == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bWr = jSONObject.optInt("agree_icon", 0);
        }
    }
}
