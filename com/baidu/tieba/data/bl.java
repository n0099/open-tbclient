package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private String f1000a = null;
    private String b = null;
    private String c = null;
    private int d = -1;
    private boolean e = false;

    public void a(String str) {
        this.f1000a = str;
    }

    public String a() {
        return this.f1000a;
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
                this.f1000a = jSONObject.optString("tag_id");
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("TagData", "parserJson", "error = " + e.getMessage());
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
