package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aNn;

    public boolean Gq() {
        return this.aNn == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNn = jSONObject.optInt("agree_icon", 0);
        }
    }
}
