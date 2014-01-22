package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bc {
    private String a = null;
    private String d = null;
    private String b = null;
    private int c = 0;
    private bg e = new bg();

    public String a() {
        return this.d;
    }

    public bg b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("tid");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("reply_amount", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.d = optJSONObject.optString("name_show");
                }
                this.e.a(jSONObject.optJSONObject("photo"));
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b("HotspotData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
