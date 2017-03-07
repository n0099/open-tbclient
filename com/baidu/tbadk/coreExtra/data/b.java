package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aos;
    public int aot;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aos = jSONObject.optInt("logined");
                this.aot = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
