package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private int f1453a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f1453a;
    }

    public String b() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1453a = jSONObject.optInt("errno");
                this.b = jSONObject.optString("errmsg");
                this.c = jSONObject.optString("usermsg");
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
