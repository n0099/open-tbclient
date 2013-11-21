package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private int f1169a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f1169a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(int i) {
        this.f1169a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1169a = jSONObject.optInt("type");
                if (this.f1169a == 3) {
                    this.b = jSONObject.optString("big_pic");
                } else if (this.f1169a == 5) {
                    this.b = jSONObject.optString("vpic");
                    this.c = jSONObject.optString("vsrc");
                }
            } catch (Exception e) {
                bg.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
