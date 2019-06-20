package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int cer;

    public boolean akT() {
        return this.cer == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cer = jSONObject.optInt("agree_icon", 0);
        }
    }
}
