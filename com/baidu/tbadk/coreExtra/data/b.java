package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public int aoH;
    public int aoI;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aoH = jSONObject.optInt("logined");
                this.aoI = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
