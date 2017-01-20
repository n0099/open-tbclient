package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aiV;
    public int aiW;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aiV = jSONObject.optInt("logined");
                this.aiW = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
