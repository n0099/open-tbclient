package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.util.bo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private long a;
    private String b;
    private String c;
    private String d;
    private String e;

    public av() {
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
    }

    public av(long j, String str, String str2) {
        this.a = -1L;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "";
        this.a = j;
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
            bo.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optLong("message_id");
                this.b = jSONObject.optString("link");
                this.c = jSONObject.optString(PushConstants.EXTRA_CONTENT);
                this.d = jSONObject.optString("to");
                this.e = jSONObject.optString("stat");
            } catch (Exception e) {
                bo.b("MssageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public long b() {
        return this.a;
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
