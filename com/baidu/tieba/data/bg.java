package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    private int f1023a = 0;
    private String b = null;

    public int a() {
        return this.f1023a;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("error"));
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1023a = jSONObject.optInt("errno");
            this.b = jSONObject.optString("usermsg");
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
