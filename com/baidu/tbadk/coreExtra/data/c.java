package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int cut;

    public boolean aoR() {
        return this.cut == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cut = jSONObject.optInt("agree_icon", 0);
        }
    }
}
