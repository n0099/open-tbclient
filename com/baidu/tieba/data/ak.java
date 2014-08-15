package com.baidu.tieba.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private String a = "";
    private String b = "";
    private String c = "";
    private long d = System.currentTimeMillis();
    private String e = "";
    private boolean f = false;
    private boolean g = false;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        return (this.a == null || akVar.a == null || !this.a.equals(akVar.a)) ? false : true;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        if (TextUtils.isEmpty(this.a)) {
            hashCode = 120;
        } else {
            hashCode = this.a.hashCode() + 119;
        }
        if (TextUtils.isEmpty(this.b)) {
            hashCode2 = (hashCode * 7) + 1;
        } else {
            hashCode2 = (hashCode * 7) + this.b.hashCode();
        }
        if (TextUtils.isEmpty(this.c)) {
            hashCode3 = (hashCode2 * 7) + 1;
        } else {
            hashCode3 = (hashCode2 * 7) + this.c.hashCode();
        }
        int i = (hashCode3 * 7) + ((int) this.d);
        if (TextUtils.isEmpty(this.e)) {
            hashCode4 = (i * 7) + 1;
        } else {
            hashCode4 = (i * 7) + this.e.hashCode();
        }
        return (((this.f ? 1 : 0) + (hashCode4 * 7)) * 7) + (this.g ? 1 : 0);
    }

    public boolean a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
            String string2 = jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong("thread_time");
            this.e = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
            this.f = jSONObject.optBoolean("host_only");
            this.g = jSONObject.optBoolean("squence");
            if (!TextUtils.isEmpty(string)) {
                this.c = string;
            }
            if (!TextUtils.isEmpty(string2)) {
                this.a = string2;
            }
            if (!TextUtils.isEmpty(string3)) {
                this.b = string3;
            }
            if (j > 2000) {
                this.d = j;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, this.c);
            jSONObject.put(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.a);
            jSONObject.put("thread_time", this.d);
            jSONObject.put("thread_name", this.b);
            jSONObject.put(com.baidu.tbadk.core.frameworkData.a.POST_ID, this.e);
            jSONObject.put("host_only", this.f);
            jSONObject.put("squence", this.g);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public long e() {
        return this.d;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String f() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public boolean g() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean h() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }
}
