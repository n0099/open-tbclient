package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private int ezC;
    private int ezw;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.ezw = jSONObject.optInt("mark_rank");
            this.ezC = jSONObject.optInt("mark_score");
        }
    }

    public String aXP() {
        return this.mark_name;
    }

    public int aXX() {
        return this.ezC;
    }

    public int aXT() {
        return this.ezw;
    }

    public String aXQ() {
        return this.mark_pic;
    }
}
