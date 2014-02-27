package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class z {
    private String a = null;
    private int b = 0;

    public final void a(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final void a(int i) {
        this.b = 0;
    }

    public final int b() {
        return this.b;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optInt("class_id", 0);
                this.a = jSONObject.optString("class_name");
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("GoodData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
