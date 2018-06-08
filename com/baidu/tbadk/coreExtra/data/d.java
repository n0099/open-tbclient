package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int aAV;
    public int aAW;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aAV = jSONObject.optInt("logined");
                this.aAW = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
