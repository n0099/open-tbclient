package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private int eyF;
    private int eyL;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.eyF = jSONObject.optInt("mark_rank");
            this.eyL = jSONObject.optInt("mark_score");
        }
    }

    public String aXN() {
        return this.mark_name;
    }

    public int aXV() {
        return this.eyL;
    }

    public int aXR() {
        return this.eyF;
    }

    public String aXO() {
        return this.mark_pic;
    }
}
