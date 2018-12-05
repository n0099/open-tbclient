package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aNE;
    public int aNF;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aNE = jSONObject.optInt("logined");
                this.aNF = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
