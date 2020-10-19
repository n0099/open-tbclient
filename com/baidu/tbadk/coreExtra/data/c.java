package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int eNT;

    public boolean bpT() {
        return this.eNT == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eNT = jSONObject.optInt("agree_icon", 0);
        }
    }
}
