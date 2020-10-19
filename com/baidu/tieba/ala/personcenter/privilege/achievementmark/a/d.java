package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int hnW;
    private int hoc;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hnW = jSONObject.optInt("mark_rank");
            this.hoc = jSONObject.optInt("mark_score");
        }
    }

    public String cej() {
        return this.mark_name;
    }

    public int cer() {
        return this.hoc;
    }

    public int cen() {
        return this.hnW;
    }

    public String cek() {
        return this.mark_pic;
    }
}
