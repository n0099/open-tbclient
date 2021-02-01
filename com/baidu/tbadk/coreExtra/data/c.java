package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int fqd;

    public boolean bvV() {
        return this.fqd == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fqd = jSONObject.optInt("agree_icon", 0);
        }
    }
}
