package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class at {
    private long a;
    private String b;
    private String c;
    private String d;
    private String e;

    public at() {
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
    }

    public at(long j, String str, String str2) {
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
        this.a = -1L;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.e;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                try {
                    this.a = jSONObject.optLong("message_id");
                    this.b = jSONObject.optString("link");
                    this.c = jSONObject.optString(PushConstants.EXTRA_CONTENT);
                    this.d = jSONObject.optString("to");
                    this.e = jSONObject.optString("stat");
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b("MssageData", "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b("MssageData", "parserJson", "error = " + e2.getMessage());
        }
    }

    public final long b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }
}
