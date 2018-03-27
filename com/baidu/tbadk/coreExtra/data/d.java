package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int bhg;
    public int bhh;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bhg = jSONObject.optInt("logined");
                this.bhh = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
