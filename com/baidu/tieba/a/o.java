package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private int a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("error_code", 0);
                this.b = jSONObject.optString("error_msg");
                this.c = jSONObject.optString("error_data");
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
