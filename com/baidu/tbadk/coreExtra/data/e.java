package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dlY;
    public int dlZ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dlY = jSONObject.optInt("logined");
                this.dlZ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
