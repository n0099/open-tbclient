package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int asN;
    public int asO;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asN = jSONObject.optInt("logined");
                this.asO = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
