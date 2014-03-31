package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private String a = null;

    public final String a() {
        return this.a;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("client_id");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
