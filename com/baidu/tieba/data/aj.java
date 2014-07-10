package com.baidu.tieba.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private String a = "";
    private String b = "";
    private String c = "";
    private long d = System.currentTimeMillis();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        return (this.a == null || ajVar.a == null || !this.a.equals(ajVar.a)) ? false : true;
    }

    public boolean a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
            String string2 = jSONObject.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            String string3 = jSONObject.getString("thread_name");
            long j = jSONObject.getLong("thread_time");
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
}
