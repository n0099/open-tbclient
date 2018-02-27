package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int bhd;
    public int bhe;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bhd = jSONObject.optInt("logined");
                this.bhe = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
