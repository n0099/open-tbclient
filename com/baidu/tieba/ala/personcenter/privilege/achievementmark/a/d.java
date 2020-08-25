package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int gVk;
    private int gVq;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gVk = jSONObject.optInt("mark_rank");
            this.gVq = jSONObject.optInt("mark_score");
        }
    }

    public String bYO() {
        return this.mark_name;
    }

    public int bYW() {
        return this.gVq;
    }

    public int bYS() {
        return this.gVk;
    }

    public String bYP() {
        return this.mark_pic;
    }
}
