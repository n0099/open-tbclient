package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int aBO;
    public int aBP;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aBO = jSONObject.optInt("logined");
                this.aBP = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
