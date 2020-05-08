package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dMy;
    public int dMz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dMy = jSONObject.optInt("logined");
                this.dMz = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
