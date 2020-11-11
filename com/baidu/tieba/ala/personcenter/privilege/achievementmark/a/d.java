package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int hFO;
    private int hFU;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.hFO = jSONObject.optInt("mark_rank");
            this.hFU = jSONObject.optInt("mark_score");
        }
    }

    public String cjN() {
        return this.mark_name;
    }

    public int cjV() {
        return this.hFU;
    }

    public int cjR() {
        return this.hFO;
    }

    public String cjO() {
        return this.mark_pic;
    }
}
