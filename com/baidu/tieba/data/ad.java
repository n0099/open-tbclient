package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private String f754a = null;

    public String a() {
        return this.f754a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f754a = jSONObject.optString("name");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
