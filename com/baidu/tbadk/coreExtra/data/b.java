package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aBo;

    public boolean BJ() {
        return this.aBo == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBo = jSONObject.optInt("agree_icon", 0);
        }
    }
}
