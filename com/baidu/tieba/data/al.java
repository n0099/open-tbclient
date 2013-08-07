package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private String f974a = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f974a = jSONObject.optString("name");
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
