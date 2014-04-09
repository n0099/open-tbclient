package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class aq {
    private String a = null;
    private String d = null;
    private String b = null;
    private int c = 0;
    private ar e = new ar();

    public final String a() {
        return this.d;
    }

    public final ar b() {
        return this.e;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("tid");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("reply_amount", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.d = optJSONObject.optString("name_show");
                }
                this.e.a(jSONObject.optJSONObject("photo"));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("HotspotData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
