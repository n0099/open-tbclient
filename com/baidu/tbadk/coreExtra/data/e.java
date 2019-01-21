package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aOj;
    public int aOk;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aOj = jSONObject.optInt("logined");
                this.aOk = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
