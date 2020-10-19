package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    private int hmr;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hmr = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
