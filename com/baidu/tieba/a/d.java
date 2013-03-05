package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class d {
    public abstract void a(JSONObject jSONObject);

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }
}
