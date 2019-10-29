package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int cuM;
    public int cuN;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cuM = jSONObject.optInt("logined");
                this.cuN = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
