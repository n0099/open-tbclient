package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int fZG;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fZG = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
