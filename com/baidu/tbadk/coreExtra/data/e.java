package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int cfN;
    public int cfO;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cfN = jSONObject.optInt("logined");
                this.cfO = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
