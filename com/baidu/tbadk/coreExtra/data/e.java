package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public int ezY;
    public int ezZ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ezY = jSONObject.optInt("logined");
                this.ezZ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
