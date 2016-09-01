package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int ajI;
    public int ajJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ajI = jSONObject.optInt("logined");
                this.ajJ = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
