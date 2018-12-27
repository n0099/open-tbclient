package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aNG;
    public int aNH;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aNG = jSONObject.optInt("logined");
                this.aNH = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
