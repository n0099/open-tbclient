package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private int bgS;

    public boolean Fr() {
        return this.bgS == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bgS = jSONObject.optInt("agree_icon", 0);
        }
    }
}
