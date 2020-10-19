package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public int eOp;
    public int logined;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.logined = jSONObject.optInt("logined");
                this.eOp = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
