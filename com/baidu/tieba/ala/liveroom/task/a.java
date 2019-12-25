package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public int fek;
    public String fel;
    public int fem;
    public int fen;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fek = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.fel = jSONObject.optString("righttips");
            this.fem = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fen = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
