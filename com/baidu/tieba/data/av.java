package com.baidu.tieba.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private int f772a = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int b = 0;
    private int f = 3;
    private int g = 0;

    public void a(int i) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f772a;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.f772a = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.f;
    }

    public void d(int i) {
        this.g = i;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.f772a = optJSONObject.getInt("is_sign_in");
                this.c = optJSONObject.getInt("user_sign_rank");
                this.d = optJSONObject.getInt("cont_sign_num");
                this.e = optJSONObject.getInt("cout_total_sing_num");
                this.f = optJSONObject.getInt("sign_bonus_point");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
