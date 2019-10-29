package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public int eoB;
    public String eoC;
    public int eoD;
    public int eoE;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eoB = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.eoC = jSONObject.optString("righttips");
            this.eoD = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.eoE = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
