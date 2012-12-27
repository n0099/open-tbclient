package com.baidu.tieba.a;

import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class an {
    private long a = 0;
    private String b = null;
    private String c = null;

    public long a() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getJSONObject(i) != null) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (this.a < jSONObject2.getLong("message_id")) {
                        this.a = jSONObject2.getLong("message_id");
                        this.b = jSONObject2.getString("link");
                        this.c = jSONObject2.getString("content");
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
