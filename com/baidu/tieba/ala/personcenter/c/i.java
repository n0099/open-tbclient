package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    private int hZJ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hZJ = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
