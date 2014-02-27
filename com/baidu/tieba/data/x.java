package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class x {
    private int a;
    private String b;
    private String c;

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("bannerType");
                this.b = jSONObject.optString("bannerUrl");
                this.c = jSONObject.optString("value");
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
