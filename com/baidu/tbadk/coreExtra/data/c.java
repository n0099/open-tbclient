package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private int ezE;

    public boolean bmp() {
        return this.ezE == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ezE = jSONObject.optInt("agree_icon", 0);
        }
    }
}
