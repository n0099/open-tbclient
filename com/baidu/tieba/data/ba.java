package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az f999a;
    private int b;
    private String c;
    private String d;

    public ba(az azVar) {
        this.f999a = azVar;
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
    public ba a(JSONObject jSONObject) {
        ba baVar = new ba(this.f999a);
        baVar.a(jSONObject.optInt("errno"));
        baVar.a(jSONObject.optString("errmsg"));
        baVar.b(jSONObject.optString("usermsg"));
        return baVar;
    }
}
