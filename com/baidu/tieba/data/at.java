package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private long f1227a;
    private String b;
    private String c;
    private String d;
    private String e;

    public at() {
        this.f1227a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
    }

    public at(long j, String str, String str2) {
        this.f1227a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
        this.f1227a = j;
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
            com.baidu.tieba.util.bd.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1227a = jSONObject.optLong("message_id");
                this.b = jSONObject.optString("link");
                this.c = jSONObject.optString("content");
                this.d = jSONObject.optString("to");
                this.e = jSONObject.optString("stat");
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b("MssageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public long b() {
        return this.f1227a;
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
