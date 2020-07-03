package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int gDk;
    private int gDq;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gDk = jSONObject.optInt("mark_rank");
            this.gDq = jSONObject.optInt("mark_score");
        }
    }

    public String bLF() {
        return this.mark_name;
    }

    public int bLN() {
        return this.gDq;
    }

    public int bLJ() {
        return this.gDk;
    }

    public String bLG() {
        return this.mark_pic;
    }
}
