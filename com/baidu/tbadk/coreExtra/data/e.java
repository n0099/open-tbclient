package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int cfU;
    public int cfV;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cfU = jSONObject.optInt("logined");
                this.cfV = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
