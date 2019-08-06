package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int cfB;

    public boolean ama() {
        return this.cfB == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cfB = jSONObject.optInt("agree_icon", 0);
        }
    }
}
