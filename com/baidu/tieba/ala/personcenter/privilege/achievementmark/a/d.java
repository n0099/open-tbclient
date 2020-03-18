package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int fwL;
    private int fwR;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.fwL = jSONObject.optInt("mark_rank");
            this.fwR = jSONObject.optInt("mark_score");
        }
    }

    public String bsy() {
        return this.mark_name;
    }

    public int bsG() {
        return this.fwR;
    }

    public int bsC() {
        return this.fwL;
    }

    public String bsz() {
        return this.mark_pic;
    }
}
