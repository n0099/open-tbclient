package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private String f973a = null;
    private int b = 0;

    public void a(String str) {
        this.f973a = str;
    }

    public String a() {
        return this.f973a;
    }

    public void a(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optInt("class_id", 0);
                this.f973a = jSONObject.optString("class_name");
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("GoodData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
