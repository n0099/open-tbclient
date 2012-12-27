package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class c {
    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public abstract void a(JSONObject jSONObject);
}
