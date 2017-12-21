package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aqV;

    public boolean xE() {
        return this.aqV == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aqV = jSONObject.optInt("agree_icon", 0);
        }
    }
}
