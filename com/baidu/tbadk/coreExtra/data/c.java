package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public int aqI;
    public int aqJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqI = jSONObject.optInt("logined");
                this.aqJ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
