package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private int fun;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fun = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
