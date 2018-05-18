package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int asO;
    public int asP;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asO = jSONObject.optInt("logined");
                this.asP = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
