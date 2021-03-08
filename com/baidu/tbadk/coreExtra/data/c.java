package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int frE;

    public boolean bvY() {
        return this.frE == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.frE = jSONObject.optInt("agree_icon", 0);
        }
    }
}
