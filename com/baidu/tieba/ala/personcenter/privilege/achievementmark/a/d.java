package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int hzR;
    private int hzX;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hzR = jSONObject.optInt("mark_rank");
            this.hzX = jSONObject.optInt("mark_score");
        }
    }

    public String chl() {
        return this.mark_name;
    }

    public int cht() {
        return this.hzX;
    }

    public int chp() {
        return this.hzR;
    }

    public String chm() {
        return this.mark_pic;
    }
}
