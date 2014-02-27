package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ad {
    private String a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private int f = 0;
    private String e = null;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int c() {
        return this.d;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final int d() {
        return this.c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("forum_id");
                this.b = jSONObject.optString("forum_name");
                this.f = jSONObject.optInt("is_like", 0);
                this.d = jSONObject.optInt("is_sign", 0);
                this.c = jSONObject.optInt("level_id", 0);
                this.e = jSONObject.optString("avatar", "");
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("BrowseForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final int e() {
        return this.f;
    }
}
