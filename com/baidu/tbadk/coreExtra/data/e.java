package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int epM;
    public int epN;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.epM = jSONObject.optInt("logined");
                this.epN = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
