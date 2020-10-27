package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public int eWL;
    public int logined;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.logined = jSONObject.optInt("logined");
                this.eWL = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
