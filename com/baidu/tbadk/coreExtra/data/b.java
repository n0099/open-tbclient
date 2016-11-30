package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int akg;
    public int akh;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akg = jSONObject.optInt("logined");
                this.akh = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
