package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int eaP;
    public int eaQ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eaP = jSONObject.optInt("logined");
                this.eaQ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
