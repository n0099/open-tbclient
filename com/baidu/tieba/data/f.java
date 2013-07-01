package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f786a = null;

    public String a() {
        return this.f786a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f786a = jSONObject.optString("client_id");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
