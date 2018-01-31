package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bfj;

    public boolean EW() {
        return this.bfj == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bfj = jSONObject.optInt("agree_icon", 0);
        }
    }
}
