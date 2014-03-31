package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    private int a = 0;
    private int b = 0;

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("group_count", 0);
                this.b = jSONObject.optInt("hide_recommend_group", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FrsStarData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }
}
