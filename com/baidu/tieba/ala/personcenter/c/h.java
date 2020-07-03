package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int gBF;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gBF = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
