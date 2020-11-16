package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int hFB;
    private int hFv;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hFv = jSONObject.optInt("mark_rank");
            this.hFB = jSONObject.optInt("mark_score");
        }
    }

    public String cjg() {
        return this.mark_name;
    }

    public int cjo() {
        return this.hFB;
    }

    public int cjk() {
        return this.hFv;
    }

    public String cjh() {
        return this.mark_pic;
    }
}
