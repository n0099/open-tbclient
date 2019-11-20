package com.baidu.tieba.ala.guardclub.model;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {
    public String dNO;
    public String dNP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dNO = jSONObject.optString("privilege_img_url");
                this.dNP = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
