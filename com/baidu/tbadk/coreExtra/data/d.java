package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int ari;
    public int arj;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ari = jSONObject.optInt("logined");
                this.arj = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
