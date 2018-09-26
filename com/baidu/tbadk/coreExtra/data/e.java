package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aEK;
    public int aEL;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aEK = jSONObject.optInt("logined");
                this.aEL = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
