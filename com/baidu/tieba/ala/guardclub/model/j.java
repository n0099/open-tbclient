package com.baidu.tieba.ala.guardclub.model;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {
    public String dOF;
    public String dOG;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dOF = jSONObject.optString("privilege_img_url");
                this.dOG = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
