package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {
    private int a = 0;
    private String b = null;
    private ad c = new ad();

    public ad a() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("error_msg");
                this.a = jSONObject.optInt("error_code", 0);
                this.c.a(jSONObject.optJSONObject("info"));
            } catch (Exception e) {
                com.baidu.tieba.c.af.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
