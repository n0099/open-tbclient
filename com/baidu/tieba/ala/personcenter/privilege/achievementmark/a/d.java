package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    private int hWS;
    private int hWY;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hWS = jSONObject.optInt("mark_rank");
            this.hWY = jSONObject.optInt("mark_score");
        }
    }

    public String cmc() {
        return this.mark_name;
    }

    public int cmk() {
        return this.hWY;
    }

    public int cmg() {
        return this.hWS;
    }

    public String cmd() {
        return this.mark_pic;
    }
}
