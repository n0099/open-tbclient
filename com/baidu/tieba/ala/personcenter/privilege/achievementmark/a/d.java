package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int gVo;
    private int gVu;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gVo = jSONObject.optInt("mark_rank");
            this.gVu = jSONObject.optInt("mark_score");
        }
    }

    public String bYP() {
        return this.mark_name;
    }

    public int bYX() {
        return this.gVu;
    }

    public int bYT() {
        return this.gVo;
    }

    public String bYQ() {
        return this.mark_pic;
    }
}
