package com.baidu.tieba.ala.liveroom.task;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public int enK;
    public String enL;
    public int enM;
    public int enN;
    public String tips;
    public String title;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.enK = jSONObject.optInt("istip");
            this.tips = jSONObject.optString("tips");
            this.enL = jSONObject.optString("righttips");
            this.enM = jSONObject.optInt("upperlimit");
            this.url = jSONObject.optString("url");
            this.enN = jSONObject.optInt("isreward");
            this.title = jSONObject.optString("title");
        }
    }
}
