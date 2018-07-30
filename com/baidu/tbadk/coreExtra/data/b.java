package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int aBr;

    public boolean BM() {
        return this.aBr == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBr = jSONObject.optInt("agree_icon", 0);
        }
    }
}
