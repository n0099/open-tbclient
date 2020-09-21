package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int eBM;

    public boolean bnj() {
        return this.eBM == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eBM = jSONObject.optInt("agree_icon", 0);
        }
    }
}
