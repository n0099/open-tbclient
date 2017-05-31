package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aow;
    public int aox;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aow = jSONObject.optInt("logined");
                this.aox = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
