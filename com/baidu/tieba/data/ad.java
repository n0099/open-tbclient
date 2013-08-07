package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private int f966a = -1;
    private String b = null;
    private String c = null;
    private int d;
    private int e;
    private int f;
    private int g;

    public ad() {
        a(0);
        b(0);
        c(0);
        d(0);
    }

    public int a() {
        return this.f966a;
    }

    public String b() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f966a = jSONObject.optInt("type");
                this.b = jSONObject.optString("small_pic");
                this.c = jSONObject.optString("big_pic");
                JSONObject optJSONObject = jSONObject.optJSONObject("picInfo");
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("orignal");
                    if (optJSONObject2 != null) {
                        this.d = optJSONObject2.optInt("width");
                        this.e = optJSONObject2.optInt("height");
                    }
                    if (optJSONObject.optJSONObject("small") != null) {
                        this.f = optJSONObject2.optInt("width");
                        this.g = optJSONObject2.optInt("height");
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public void d(int i) {
        this.g = i;
    }
}
