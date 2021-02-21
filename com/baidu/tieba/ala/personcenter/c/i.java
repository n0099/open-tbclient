package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    private int hZX;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hZX = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
