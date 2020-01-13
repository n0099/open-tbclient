package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dhS;
    public int dhT;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dhS = jSONObject.optInt("logined");
                this.dhT = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
