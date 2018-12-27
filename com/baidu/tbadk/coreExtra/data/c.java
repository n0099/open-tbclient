package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aNp;

    public boolean Gr() {
        return this.aNp == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNp = jSONObject.optInt("agree_icon", 0);
        }
    }
}
