package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bhb;

    public boolean Fr() {
        return this.bhb == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bhb = jSONObject.optInt("agree_icon", 0);
        }
    }
}
