package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private long f1175a;
    private String b;
    private String c;
    private String d;
    private String e;

    public au() {
        this.f1175a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
    }

    public au(long j, String str, String str2) {
        this.f1175a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
        this.f1175a = j;
        this.b = str;
        this.c = str2;
    }

    public String a() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            bg.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1175a = jSONObject.optLong("message_id");
                this.b = jSONObject.optString("link");
                this.c = jSONObject.optString("content");
                this.d = jSONObject.optString("to");
                this.e = jSONObject.optString("stat");
            } catch (Exception e) {
                bg.b("MssageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public long b() {
        return this.f1175a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }
}
