package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private String f1145a;
    private String b;
    private String c;
    private int d;
    private long e;
    private long f;
    private int g;
    private az h;

    public void a(String str) {
        this.f1145a = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void b(long j) {
        this.f = j;
    }

    public void b(int i) {
        this.g = i;
    }

    public void a(az azVar) {
        this.h = azVar;
    }

    public ay d(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ay a(JSONObject jSONObject) {
        az a2;
        ay ayVar = new ay();
        ayVar.a(jSONObject.optString("share_id"));
        ayVar.b(jSONObject.optString("share_text"));
        ayVar.c(jSONObject.optString("result_pic"));
        ayVar.a(jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE));
        ayVar.a(jSONObject.optLong("time"));
        ayVar.b(jSONObject.optLong("ctime"));
        ayVar.b(jSONObject.optInt("logid"));
        a2 = new az(this).a(jSONObject.optJSONObject("error"));
        ayVar.a(a2);
        return ayVar;
    }
}
