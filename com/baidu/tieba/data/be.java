package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class be {
    private int a = 0;
    private int b = 0;
    private String c = "";

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("is_lpost", 0);
                this.b = jSONObject.optInt("topic_type", 0);
                this.c = jSONObject.optString("link", "");
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
