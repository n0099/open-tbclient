package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public int ara;
    public int arb;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ara = jSONObject.optInt("logined");
                this.arb = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
