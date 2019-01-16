package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aOi;
    public int aOj;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aOi = jSONObject.optInt("logined");
                this.aOj = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
