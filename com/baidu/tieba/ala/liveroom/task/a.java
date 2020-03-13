package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public int fkK;
    public String fkL;
    public int fkM;
    public int fkN;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fkK = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.fkL = jSONObject.optString("righttips");
            this.fkM = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.fkN = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
