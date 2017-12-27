package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int bfi;
    public int bfj;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bfi = jSONObject.optInt("logined");
                this.bfj = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
