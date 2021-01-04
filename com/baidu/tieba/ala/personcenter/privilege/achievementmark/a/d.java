package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private int ibF;
    private int ibz;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.ibz = jSONObject.optInt("mark_rank");
            this.ibF = jSONObject.optInt("mark_score");
        }
    }

    public String cpT() {
        return this.mark_name;
    }

    public int cqb() {
        return this.ibF;
    }

    public int cpX() {
        return this.ibz;
    }

    public String cpU() {
        return this.mark_pic;
    }
}
