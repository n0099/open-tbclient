package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int fiM;

    public boolean bxc() {
        return this.fiM == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fiM = jSONObject.optInt("agree_icon", 0);
        }
    }
}
