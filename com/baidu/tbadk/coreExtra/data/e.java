package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int bWJ;
    public int bWK;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bWJ = jSONObject.optInt("logined");
                this.bWK = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
