package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int bWI;
    public int bWJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bWI = jSONObject.optInt("logined");
                this.bWJ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
