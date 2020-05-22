package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int gqk;
    private int gqq;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gqk = jSONObject.optInt("mark_rank");
            this.gqq = jSONObject.optInt("mark_score");
        }
    }

    public String bIy() {
        return this.mark_name;
    }

    public int bIG() {
        return this.gqq;
    }

    public int bIC() {
        return this.gqk;
    }

    public String bIz() {
        return this.mark_pic;
    }
}
