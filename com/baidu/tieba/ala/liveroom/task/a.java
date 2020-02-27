package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int fkw;
    public String fkx;
    public int fky;
    public int fkz;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fkw = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.fkx = jSONObject.optString("righttips");
            this.fky = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fkz = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
