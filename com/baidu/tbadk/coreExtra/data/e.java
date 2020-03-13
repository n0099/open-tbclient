package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dmm;
    public int dmn;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dmm = jSONObject.optInt("logined");
                this.dmn = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
