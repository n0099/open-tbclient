package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private int exa;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.exa = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
