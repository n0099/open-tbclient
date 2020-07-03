package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int ejg;

    public boolean aZM() {
        return this.ejg == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ejg = jSONObject.optInt("agree_icon", 0);
        }
    }
}
