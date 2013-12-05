package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private int f1232a = 0;
    private String b = null;

    public int a() {
        return this.f1232a;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str).optJSONObject("error"));
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1232a = jSONObject.optInt("errno");
            this.b = jSONObject.optString("usermsg");
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.toString());
        }
    }
}
