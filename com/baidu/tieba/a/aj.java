package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private int a = 0;
    private String b = null;
    private int e = 0;
    private String c = null;
    private String d = null;
    private String f = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("id");
                this.a = jSONObject.optInt("is_login", 0);
                this.e = jSONObject.optInt("no_un", 0);
                this.c = jSONObject.optString("name");
                this.d = jSONObject.optString("name_show");
                this.f = jSONObject.optString("portrait");
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
