package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ay f1146a;
    private int b;
    private String c;
    private String d;

    public az(ay ayVar) {
        this.f1146a = ayVar;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public az a(JSONObject jSONObject) {
        az azVar = new az(this.f1146a);
        azVar.a(jSONObject.optInt("errno"));
        azVar.a(jSONObject.optString("errmsg"));
        azVar.b(jSONObject.optString("usermsg"));
        return azVar;
    }
}
