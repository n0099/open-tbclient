package com.baidu.tieba.ala.guardclub.model;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public String eBV;
    public String eBW;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eBV = jSONObject.optString("privilege_img_url");
                this.eBW = jSONObject.optString("privilege_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
