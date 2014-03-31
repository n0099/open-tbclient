package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class p {
    private int a = -1;
    private String b = null;
    private String c = null;

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("errno");
                this.b = jSONObject.optString("errmsg");
                this.c = jSONObject.optString("usermsg");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
