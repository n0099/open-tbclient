package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int bWL;
    public int bWM;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bWL = jSONObject.optInt("logined");
                this.bWM = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
