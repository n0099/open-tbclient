package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private int a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("type");
                if (this.a == 3) {
                    this.b = jSONObject.optString("big_pic");
                } else if (this.a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
