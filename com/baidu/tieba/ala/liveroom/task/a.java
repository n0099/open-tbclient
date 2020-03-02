package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int fkA;
    public int fkx;
    public String fky;
    public int fkz;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fkx = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.fky = jSONObject.optString("righttips");
            this.fkz = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fkA = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
