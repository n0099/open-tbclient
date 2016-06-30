package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public int afW;
    public int afX;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.afW = jSONObject.optInt("logined");
                this.afX = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
