package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aEt;

    public boolean CX() {
        return this.aEt == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aEt = jSONObject.optInt("agree_icon", 0);
        }
    }
}
