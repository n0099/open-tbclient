package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int fZL;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fZL = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
