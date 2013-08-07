package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    private long f976a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    public void a(long j) {
        this.f976a = j;
    }

    public long a() {
        return this.f976a;
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

    public long d() {
        return this.d;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("message"));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("MessageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f976a = jSONObject.optLong("replyme", 0L);
                this.b = jSONObject.optLong("atme", 0L);
                this.c = jSONObject.optLong("fans", 0L);
                this.d = jSONObject.optLong("pletter", 0L);
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("MessageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
