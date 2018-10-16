package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int aJo;
    public int aJp;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aJo = jSONObject.optInt("logined");
                this.aJp = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
