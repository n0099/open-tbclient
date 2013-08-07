package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private int f977a = -1;
    private String b = null;

    public int a() {
        return this.f977a;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str).optJSONObject("error"));
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f977a = jSONObject.optInt("errno");
                this.b = jSONObject.optString("usermsg");
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
