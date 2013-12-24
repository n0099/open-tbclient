package com.baidu.tieba.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {
    private String a = null;
    private String b = null;
    private String c = null;
    private int d = 0;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getString("title");
            this.b = jSONObject.getString("title_link");
            this.c = jSONObject.getString("author");
            this.d = jSONObject.getInt("id");
            com.baidu.tieba.util.be.c("TOPNotice:title:" + this.a + " link:" + this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
