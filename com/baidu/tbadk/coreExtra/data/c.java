package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int cgu;

    public boolean amm() {
        return this.cgu == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cgu = jSONObject.optInt("agree_icon", 0);
        }
    }
}
