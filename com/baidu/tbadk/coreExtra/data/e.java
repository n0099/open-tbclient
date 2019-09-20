package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int cgN;
    public int cgO;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cgN = jSONObject.optInt("logined");
                this.cgO = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
