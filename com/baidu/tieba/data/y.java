package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private String f1031a = null;
    private int b = 0;

    public void a(String str) {
        this.f1031a = str;
    }

    public String a() {
        return this.f1031a;
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
                this.f1031a = jSONObject.optString("class_name");
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("GoodData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
