package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private int fqg;
    private int fqm;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.fqg = jSONObject.optInt("mark_rank");
            this.fqm = jSONObject.optInt("mark_score");
        }
    }

    public String bpK() {
        return this.mark_name;
    }

    public int bpS() {
        return this.fqm;
    }

    public int bpO() {
        return this.fqg;
    }

    public String bpL() {
        return this.mark_pic;
    }
}
