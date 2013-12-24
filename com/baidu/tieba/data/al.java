package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private String a = null;
    private aq b = null;
    private aq c = null;
    private String d = null;
    private String e = null;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private int i = 0;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("pk_id", null);
                this.b = new aq();
                this.b.a(jSONObject.optJSONObject("player1"));
                this.c = new aq();
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
}
