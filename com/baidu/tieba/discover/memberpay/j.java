package com.baidu.tieba.discover.memberpay;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    long aoF;
    String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mName = jSONObject.optString("name");
            this.aoF = jSONObject.optLong("num");
        }
    }
}
