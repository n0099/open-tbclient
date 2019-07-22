package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int cfu;

    public boolean alY() {
        return this.cfu == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cfu = jSONObject.optInt("agree_icon", 0);
        }
    }
}
