package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private int ibA;
    private int ibG;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.ibA = jSONObject.optInt("mark_rank");
            this.ibG = jSONObject.optInt("mark_score");
        }
    }

    public String cnh() {
        return this.mark_name;
    }

    public int cnp() {
        return this.ibG;
    }

    public int cnl() {
        return this.ibA;
    }

    public String cni() {
        return this.mark_pic;
    }
}
