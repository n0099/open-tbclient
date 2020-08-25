package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int gTF;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gTF = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
