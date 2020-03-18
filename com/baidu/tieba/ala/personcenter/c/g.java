package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private int fvg;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fvg = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
