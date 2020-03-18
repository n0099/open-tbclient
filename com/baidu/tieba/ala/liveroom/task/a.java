package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int flj;
    public String flk;
    public int fll;
    public int flm;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.flj = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.flk = jSONObject.optString("righttips");
            this.fll = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.flm = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
