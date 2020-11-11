package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    private int hEj;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hEj = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
