package com.baidu.tieba.frs;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int a;
    private String b;
    private String c;

    public String a() {
        return this.b;
    }

    public String b() {
        return String.valueOf(this.a);
    }

    public String c() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("badge_id", 0);
                this.b = jSONObject.optString("badge_url", "");
                this.c = jSONObject.optString("webview");
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b("BadgeData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
