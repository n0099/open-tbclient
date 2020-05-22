package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private int goF;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.goF = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
