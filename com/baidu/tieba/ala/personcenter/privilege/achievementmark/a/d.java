package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private int hPe;
    private int hPk;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hPe = jSONObject.optInt("mark_rank");
            this.hPk = jSONObject.optInt("mark_score");
        }
    }

    public String cnb() {
        return this.mark_name;
    }

    public int cnj() {
        return this.hPk;
    }

    public int cnf() {
        return this.hPe;
    }

    public String cnc() {
        return this.mark_pic;
    }
}
