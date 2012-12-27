package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private int a = 0;
    private String b = null;
    private ac c = new ac();

    public ac a() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.b = jSONObject.optString("error_msg");
            this.a = jSONObject.optInt("error_code", 0);
            this.c.a(jSONObject.optJSONObject("info"));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
        }
    }
}
