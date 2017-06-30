package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int apx;
    public int apy;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.apx = jSONObject.optInt("logined");
                this.apy = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
