package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int fce;

    public boolean bum() {
        return this.fce == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fce = jSONObject.optInt("agree_icon", 0);
        }
    }
}
