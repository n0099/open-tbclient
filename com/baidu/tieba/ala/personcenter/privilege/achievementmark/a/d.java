package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int fwf;
    private int fwl;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.fwf = jSONObject.optInt("mark_rank");
            this.fwl = jSONObject.optInt("mark_score");
        }
    }

    public String bss() {
        return this.mark_name;
    }

    public int bsA() {
        return this.fwl;
    }

    public int bsw() {
        return this.fwf;
    }

    public String bst() {
        return this.mark_pic;
    }
}
