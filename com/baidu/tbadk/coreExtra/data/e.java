package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public int dlZ;
    public int dma;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dlZ = jSONObject.optInt("logined");
                this.dma = jSONObject.optInt("unlogin");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
