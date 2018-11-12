package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aKe;
    public int aKf;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aKe = jSONObject.optInt("logined");
                this.aKf = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
