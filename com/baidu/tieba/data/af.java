package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class af {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private String e = "";
    private int f = 0;
    private int g = 0;
    private String h;

    public final String a() {
        return this.h;
    }

    public final void a(String str) {
        this.h = str;
    }

    public final int b() {
        return this.d;
    }

    public final void a(int i) {
        if (i >= 0) {
            this.d = i;
        }
    }

    public final void b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("info");
            if (optJSONObject != null) {
                try {
                    this.a = optJSONObject.optInt("is_like", 0);
                    this.b = optJSONObject.optInt("is_black", 0);
                    this.c = optJSONObject.optInt("like_num", 0);
                    this.d = optJSONObject.optInt("level_id", 0);
                    this.e = optJSONObject.optString("level_name", "");
                    this.g = optJSONObject.optInt("levelup_score", 0);
                    this.f = optJSONObject.optInt("cur_score", 0);
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b("LikeReturnData", "parserJson", "error = " + e2.getMessage());
        }
    }

    public final void b(int i) {
        this.a = i;
    }

    public final int c() {
        return this.a;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final String d() {
        return this.e;
    }

    public final void c(int i) {
        this.f = i;
    }

    public final int e() {
        return this.f;
    }

    public final void d(int i) {
        this.g = i;
    }

    public final int f() {
        return this.g;
    }
}
