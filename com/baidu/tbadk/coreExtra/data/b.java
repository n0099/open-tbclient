package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aqC;
    public int aqD;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqC = jSONObject.optInt("logined");
                this.aqD = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
