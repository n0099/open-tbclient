package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int arl;
    public int arm;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arl = jSONObject.optInt("logined");
                this.arm = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
