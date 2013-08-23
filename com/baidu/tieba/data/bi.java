package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    private String f1007a = null;
    private String d = null;
    private String b = null;
    private int c = 0;
    private bk e = new bk();

    public String a() {
        return this.d;
    }

    public bk b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f1007a;
    }

    public int e() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1007a = jSONObject.optString("tid");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("reply_amount", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.d = optJSONObject.optString("name_show");
                }
                this.e.a(jSONObject.optJSONObject("photo"));
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("HotspotData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
