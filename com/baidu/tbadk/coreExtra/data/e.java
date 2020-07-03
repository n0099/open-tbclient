package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int ejA;
    public int ejz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ejz = jSONObject.optInt("logined");
                this.ejA = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
