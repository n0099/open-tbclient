package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int ceH;
    public int ceI;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ceH = jSONObject.optInt("logined");
                this.ceI = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
