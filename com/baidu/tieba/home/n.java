package com.baidu.tieba.home;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    private int a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("errno");
                this.b = jSONObject.optString("errmsg");
                this.c = jSONObject.optString("usermsg");
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
