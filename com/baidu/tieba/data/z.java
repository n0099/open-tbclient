package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class z {
    private int a;
    private int b;
    private int c;
    private int d;
    private String e;
    private int f;
    private int g;
    private String h;

    public z() {
        b(0);
        c(0);
        d(0);
        this.d = 0;
        c("");
        e(0);
        f(0);
    }

    public String a() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        if (i >= 0) {
            this.d = i;
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str).optJSONObject("info"));
        } catch (Exception e) {
            BdLog.e("LikeReturnData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                b(jSONObject.optInt("is_like", 0));
                c(jSONObject.optInt("is_black", 0));
                d(jSONObject.optInt("like_num", 0));
                this.d = jSONObject.optInt("level_id", 0);
                c(jSONObject.optString("level_name", ""));
                f(jSONObject.optInt("levelup_score", 0));
                e(jSONObject.optInt("cur_score", 0));
            } catch (Exception e) {
                BdLog.e("LikeReturnData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void b(int i) {
        this.a = i;
    }

    public int c() {
        return this.a;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.e = str;
    }

    public String d() {
        return this.e;
    }

    public void e(int i) {
        this.f = i;
    }

    public int e() {
        return this.f;
    }

    public void f(int i) {
        this.g = i;
    }

    public int f() {
        return this.g;
    }
}
