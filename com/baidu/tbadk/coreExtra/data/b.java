package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bfa;

    public boolean EU() {
        return this.bfa == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bfa = jSONObject.optInt("agree_icon", 0);
        }
    }
}
