package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dMu;
    public int dMv;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dMu = jSONObject.optInt("logined");
                this.dMv = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
