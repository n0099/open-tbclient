package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int agL;
    public int agM;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.agL = jSONObject.optInt("logined");
                this.agM = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
