package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private String f1133a = null;
    private ar b = null;
    private ar c = null;
    private String d = null;
    private String e = null;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private int i = 0;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1133a = jSONObject.optString("pk_id", null);
                this.b = new ar();
                this.b.a(jSONObject.optJSONObject("player1"));
                this.c = new ar();
                this.c.a(jSONObject.optJSONObject("player2"));
                this.f = jSONObject.optLong("start_time");
                this.g = jSONObject.optLong("end_time");
                this.h = jSONObject.optLong("remain_time");
                this.d = jSONObject.optString("title");
                this.i = jSONObject.optInt("status", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("PKInfoData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String a() {
        return this.f1133a;
    }

    public ar b() {
        return this.b;
    }

    public ar c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.i;
    }
}
