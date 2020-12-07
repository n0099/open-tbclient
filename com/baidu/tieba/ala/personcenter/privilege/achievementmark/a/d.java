package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private int hPc;
    private int hPi;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hPc = jSONObject.optInt("mark_rank");
            this.hPi = jSONObject.optInt("mark_score");
        }
    }

    public String cna() {
        return this.mark_name;
    }

    public int cni() {
        return this.hPi;
    }

    public int cne() {
        return this.hPc;
    }

    public String cnb() {
        return this.mark_pic;
    }
}
