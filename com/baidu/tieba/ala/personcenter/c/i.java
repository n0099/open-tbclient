package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    private int hVo;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hVo = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
