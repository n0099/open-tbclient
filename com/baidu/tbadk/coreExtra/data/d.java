package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int bfo;
    public int bfp;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bfo = jSONObject.optInt("logined");
                this.bfp = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
