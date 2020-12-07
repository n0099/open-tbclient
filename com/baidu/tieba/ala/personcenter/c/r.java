package com.baidu.tieba.ala.personcenter.c;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r {
    public String name;
    public String url;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.url = jSONObject.optString("url");
        }
    }
}
