package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private long a = 0;
    private long b = 0;
    private long c = 0;

    public void a(long j) {
        this.a = j;
    }

    public long a() {
        return this.a;
    }

    public void b(long j) {
        this.b = j;
    }

    public long b() {
        return this.b;
    }

    public void c(long j) {
        this.c = j;
    }

    public long c() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("message"));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("MessageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optLong("replyme", 0L);
                this.b = jSONObject.optLong("atme", 0L);
                this.c = jSONObject.optLong("fans", 0L);
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("MessageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
