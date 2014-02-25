package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int a = 0;
    private int b = 0;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("group_count", 0);
                this.b = jSONObject.optInt("hide_recommend_group", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FrsStarData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }
}
