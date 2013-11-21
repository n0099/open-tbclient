package com.baidu.tieba.frs;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f1308a;
    private String b;
    private String c;

    public String a() {
        return this.b;
    }

    public String b() {
        return String.valueOf(this.f1308a);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1308a = jSONObject.optInt("badge_id", 0);
                this.b = jSONObject.optString("badge_url", "");
                this.c = jSONObject.optString("webview");
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b("BadgeData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
