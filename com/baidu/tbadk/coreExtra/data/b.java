package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aoM;
    public int aoN;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aoM = jSONObject.optInt("logined");
                this.aoN = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
