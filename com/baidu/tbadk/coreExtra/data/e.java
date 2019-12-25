package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dhG;
    public int dhH;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dhG = jSONObject.optInt("logined");
                this.dhH = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
