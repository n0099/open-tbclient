package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int dlT;

    public boolean aJb() {
        return this.dlT == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dlT = jSONObject.optInt("agree_icon", 0);
        }
    }
}
