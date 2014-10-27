package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    private String imageUrl;
    private String link;

    public void parserJson(JSONObject jSONObject) {
        this.imageUrl = jSONObject.optString("img");
        this.link = jSONObject.optString("link");
    }
}
