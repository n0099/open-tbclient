package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int ezI;

    public boolean bmp() {
        return this.ezI == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ezI = jSONObject.optInt("agree_icon", 0);
        }
    }
}
