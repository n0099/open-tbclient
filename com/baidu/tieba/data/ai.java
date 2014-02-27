package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ai {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;

    public final void a(int i) {
        this.a = 0;
    }

    public final int a() {
        return this.a;
    }

    public final void b(int i) {
        this.b = 0;
    }

    public final int b() {
        return this.b;
    }

    public final void c(int i) {
        this.c = 0;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final void d(int i) {
        this.d = 0;
    }

    public final int e() {
        return this.e;
    }

    public final void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("MessageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("replyme", 0);
                this.b = jSONObject.optInt("atme", 0);
                this.c = jSONObject.optInt("fans", 0);
                this.d = jSONObject.optInt("pletter", 0);
                this.e = jSONObject.optInt("bookmark", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("MessageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
