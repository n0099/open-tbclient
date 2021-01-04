package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int fsv;

    public boolean bzv() {
        return this.fsv == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fsv = jSONObject.optInt("agree_icon", 0);
        }
    }
}
