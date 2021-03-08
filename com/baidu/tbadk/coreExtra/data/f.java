package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public int fsa;
    public int logined;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.logined = jSONObject.optInt("logined");
                this.fsa = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
