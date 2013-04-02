package com.baidu.tieba.a;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw {
    private String a = null;
    private String b = null;
    private String c = null;
    private int d = -1;
    private boolean e = false;

    public void a(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void b(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("tag_name");
                this.a = jSONObject.optString("tag_id");
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("TagData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }
}
