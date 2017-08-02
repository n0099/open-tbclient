package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aqo;
    public int aqp;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aqo = jSONObject.optInt("logined");
                this.aqp = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
