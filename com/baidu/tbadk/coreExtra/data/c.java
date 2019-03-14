package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int bWs;

    public boolean afX() {
        return this.bWs == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bWs = jSONObject.optInt("agree_icon", 0);
        }
    }
}
