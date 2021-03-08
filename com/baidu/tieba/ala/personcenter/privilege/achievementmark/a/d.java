package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private int idj;
    private int idq;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.idj = jSONObject.optInt("mark_rank");
            this.idq = jSONObject.optInt("mark_score");
        }
    }

    public String cnn() {
        return this.mark_name;
    }

    public int cnv() {
        return this.idq;
    }

    public int cnr() {
        return this.idj;
    }

    public String cno() {
        return this.mark_pic;
    }
}
