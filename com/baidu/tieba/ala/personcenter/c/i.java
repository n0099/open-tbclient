package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    private int hym;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hym = jSONObject.optInt("video_count");
            } catch (Exception e) {
            }
        }
    }
}
