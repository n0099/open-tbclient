package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aqh;
    public int aqi;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqh = jSONObject.optInt("logined");
                this.aqi = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
