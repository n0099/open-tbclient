package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aBx;

    public boolean BU() {
        return this.aBx == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBx = jSONObject.optInt("agree_icon", 0);
        }
    }
}
