package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int hNx;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hNx = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
