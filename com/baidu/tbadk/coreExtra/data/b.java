package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int ajo;
    public int ajp;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ajo = jSONObject.optInt("logined");
                this.ajp = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
