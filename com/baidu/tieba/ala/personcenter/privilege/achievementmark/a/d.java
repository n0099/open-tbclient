package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private int ftp;
    private int ftw;
    private String mark_name;
    private String mark_pic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mark_name = jSONObject.optString("mark_name");
            this.mark_pic = jSONObject.optString("mark_pic");
            this.ftp = jSONObject.optInt("mark_rank");
            this.ftw = jSONObject.optInt("mark_score");
        }
    }

    public String bqL() {
        return this.mark_name;
    }

    public int bqT() {
        return this.ftw;
    }

    public int bqP() {
        return this.ftp;
    }

    public String bqM() {
        return this.mark_pic;
    }
}
