package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private String f980a = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f980a = jSONObject.optString("name");
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
