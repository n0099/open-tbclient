package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public int bhp;
    public int bhq;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bhp = jSONObject.optInt("logined");
                this.bhq = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
