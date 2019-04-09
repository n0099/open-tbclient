package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int bWM;
    public int bWN;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bWM = jSONObject.optInt("logined");
                this.bWN = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
