package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bgP;

    public boolean Fq() {
        return this.bgP == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bgP = jSONObject.optInt("agree_icon", 0);
        }
    }
}
