package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int ceq;

    public boolean akT() {
        return this.ceq == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ceq = jSONObject.optInt("agree_icon", 0);
        }
    }
}
