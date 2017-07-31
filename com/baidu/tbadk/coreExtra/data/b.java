package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int arH;
    public int arI;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arH = jSONObject.optInt("logined");
                this.arI = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
