package com.baidu.tieba.forbidden.fans;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public long id;
    public String name;
    public String nameShow;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.id = jSONObject.optLong("id");
            this.name = jSONObject.optString("name");
            this.nameShow = jSONObject.optString("name_show");
            this.portrait = jSONObject.optString("portrait");
        }
    }
}
