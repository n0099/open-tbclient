package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public int fhq;
    public String fhr;
    public int fhs;
    public int fht;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fhq = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.fhr = jSONObject.optString("righttips");
            this.fhs = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fht = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
