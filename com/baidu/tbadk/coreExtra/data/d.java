package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int arf;
    public int arg;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arf = jSONObject.optInt("logined");
                this.arg = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
