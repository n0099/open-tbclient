package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    private int gYV;
    private int gZb;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.gYV = jSONObject.optInt("mark_rank");
            this.gZb = jSONObject.optInt("mark_score");
        }
    }

    public String caL() {
        return this.mark_name;
    }

    public int caT() {
        return this.gZb;
    }

    public int caP() {
        return this.gYV;
    }

    public String caM() {
        return this.mark_pic;
    }
}
