package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int eAc;
    public int eAd;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eAc = jSONObject.optInt("logined");
                this.eAd = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
