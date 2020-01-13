package com.baidu.tieba.ala.guardclub.model;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public String eDg;
    public String eDh;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eDg = jSONObject.optString("privilege_img_url");
                this.eDh = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
