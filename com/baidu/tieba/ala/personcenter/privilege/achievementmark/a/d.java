package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int fvS;
    private int fvY;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.fvS = jSONObject.optInt("mark_rank");
            this.fvY = jSONObject.optInt("mark_score");
        }
    }

    public String bsr() {
        return this.mark_name;
    }

    public int bsz() {
        return this.fvY;
    }

    public int bsv() {
        return this.fvS;
    }

    public String bss() {
        return this.mark_pic;
    }
}
