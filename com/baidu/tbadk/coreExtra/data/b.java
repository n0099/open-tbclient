package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int arI;
    public int arJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arI = jSONObject.optInt("logined");
                this.arJ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
