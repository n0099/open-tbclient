package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int gbl;
    private int gbr;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gbl = jSONObject.optInt("mark_rank");
            this.gbr = jSONObject.optInt("mark_score");
        }
    }

    public String bCg() {
        return this.mark_name;
    }

    public int bCo() {
        return this.gbr;
    }

    public int bCk() {
        return this.gbl;
    }

    public String bCh() {
        return this.mark_pic;
    }
}
