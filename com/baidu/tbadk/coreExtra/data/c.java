package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int fnK;

    public boolean bvC() {
        return this.fnK == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fnK = jSONObject.optInt("agree_icon", 0);
        }
    }
}
