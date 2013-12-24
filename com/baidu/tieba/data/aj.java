package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private long e = 0;

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
            a(new JSONObject(str).optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b("MessageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optLong("replyme", 0L);
                this.b = jSONObject.optLong("atme", 0L);
                this.c = jSONObject.optLong("fans", 0L);
                this.d = jSONObject.optLong("pletter", 0L);
                this.e = jSONObject.optLong("bookmark", 0L);
                this.d = jSONObject.optLong("pletter", 0L);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("MessageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
