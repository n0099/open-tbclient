package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int gqB;
    private int gqv;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gqv = jSONObject.optInt("mark_rank");
            this.gqB = jSONObject.optInt("mark_score");
        }
    }

    public String bIA() {
        return this.mark_name;
    }

    public int bII() {
        return this.gqB;
    }

    public int bIE() {
        return this.gqv;
    }

    public String bIB() {
        return this.mark_pic;
    }
}
