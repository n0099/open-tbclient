package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int aBI;
    public int aBJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aBI = jSONObject.optInt("logined");
                this.aBJ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
