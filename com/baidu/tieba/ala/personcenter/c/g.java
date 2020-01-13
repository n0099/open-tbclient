package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    private int frL;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.frL = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
