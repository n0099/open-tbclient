package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int gIH;
    private int gIN;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gIH = jSONObject.optInt("mark_rank");
            this.gIN = jSONObject.optInt("mark_score");
        }
    }

    public String bOO() {
        return this.mark_name;
    }

    public int bOW() {
        return this.gIN;
    }

    public int bOS() {
        return this.gIH;
    }

    public String bOP() {
        return this.mark_pic;
    }
}
