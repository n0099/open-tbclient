package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    private String f1159a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private int f = 0;
    private String e = null;

    public String a() {
        return this.f1159a;
    }

    public String b() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1159a = jSONObject.optString("forum_id");
                this.b = jSONObject.optString("forum_name");
                b(jSONObject.optInt("is_like", 0));
                this.d = jSONObject.optInt("is_sign", 0);
                this.c = jSONObject.optInt("level_id", 0);
                this.e = jSONObject.optString("avatar", "");
            } catch (Exception e) {
                bg.b("BrowseForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void b(int i) {
        this.f = i;
    }

    public int e() {
        return this.f;
    }
}
