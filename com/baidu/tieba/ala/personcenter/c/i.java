package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    private int ibG;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ibG = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
