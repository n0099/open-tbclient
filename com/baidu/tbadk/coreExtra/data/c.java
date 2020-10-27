package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int eWp;

    public boolean brM() {
        return this.eWp == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eWp = jSONObject.optInt("agree_icon", 0);
        }
    }
}
