package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int eps;

    public boolean bdJ() {
        return this.eps == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eps = jSONObject.optInt("agree_icon", 0);
        }
    }
}
