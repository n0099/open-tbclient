package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dmA;
    public int dmz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dmz = jSONObject.optInt("logined");
                this.dmA = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
