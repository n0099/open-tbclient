package com.baidu.tieba.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f994a;
    private int b;
    private String c;
    private String d;

    public bf(be beVar) {
        this.f994a = beVar;
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
    public bf a(JSONObject jSONObject) {
        try {
            bf bfVar = new bf(this.f994a);
            bfVar.a(jSONObject.getInt("errno"));
            bfVar.a(jSONObject.getString("errmsg"));
            bfVar.b(jSONObject.getString("usermsg"));
            return bfVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
