package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int fvR;
    private int fvX;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.fvR = jSONObject.optInt("mark_rank");
            this.fvX = jSONObject.optInt("mark_score");
        }
    }

    public String bsp() {
        return this.mark_name;
    }

    public int bsx() {
        return this.fvX;
    }

    public int bst() {
        return this.fvR;
    }

    public String bsq() {
        return this.mark_pic;
    }
}
