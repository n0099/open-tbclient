package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int hNz;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hNz = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
