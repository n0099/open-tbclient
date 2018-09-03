package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int aBF;
    public int aBG;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aBF = jSONObject.optInt("logined");
                this.aBG = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
