package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("client_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
