package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aqS;

    public boolean xE() {
        return this.aqS == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aqS = jSONObject.optInt("agree_icon", 0);
        }
    }
}
