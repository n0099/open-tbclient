package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int gbq;
    private int gbw;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gbq = jSONObject.optInt("mark_rank");
            this.gbw = jSONObject.optInt("mark_score");
        }
    }

    public String bCe() {
        return this.mark_name;
    }

    public int bCm() {
        return this.gbw;
    }

    public int bCi() {
        return this.gbq;
    }

    public String bCf() {
        return this.mark_pic;
    }
}
