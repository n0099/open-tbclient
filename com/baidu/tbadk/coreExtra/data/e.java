package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int ctU;
    public int ctV;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ctU = jSONObject.optInt("logined");
                this.ctV = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
