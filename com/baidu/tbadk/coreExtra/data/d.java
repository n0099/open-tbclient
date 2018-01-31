package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int bfw;
    public int bfx;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bfw = jSONObject.optInt("logined");
                this.bfx = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
