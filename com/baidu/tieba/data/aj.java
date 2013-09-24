package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    private long f1000a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private long e = 0;

    public void a(long j) {
        this.f1000a = j;
    }

    public long a() {
        return this.f1000a;
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

    public void d(long j) {
        this.d = j;
    }

    public long e() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("message"));
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("MessageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1000a = jSONObject.optLong("replyme", 0L);
                this.b = jSONObject.optLong("atme", 0L);
                this.c = jSONObject.optLong("fans", 0L);
                this.d = jSONObject.optLong("pletter", 0L);
                this.e = jSONObject.optLong("bookmark", 0L);
                this.d = jSONObject.optLong("pletter", 0L);
            } catch (Exception e) {
                com.baidu.tieba.util.av.b("MessageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
