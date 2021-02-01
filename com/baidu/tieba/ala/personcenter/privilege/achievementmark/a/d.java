package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    private int ibm;
    private int ibs;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.ibm = jSONObject.optInt("mark_rank");
            this.ibs = jSONObject.optInt("mark_score");
        }
    }

    public String cna() {
        return this.mark_name;
    }

    public int cni() {
        return this.ibs;
    }

    public int cne() {
        return this.ibm;
    }

    public String cnb() {
        return this.mark_pic;
    }
}
