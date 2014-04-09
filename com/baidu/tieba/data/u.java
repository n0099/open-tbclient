package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class u {
    private String a;
    private String b;
    private int c;
    private AntiData d;
    private Context e;
    private LinkedList<t> f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public u(Context context) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.e = context;
        this.f = new LinkedList<>();
        this.d = new AntiData();
    }

    public final boolean a() {
        return this.c > 0 && this.c <= this.f.size();
    }

    public final boolean b() {
        return (this.g == null || this.g.length() == 0 || this.h == null || this.h.length() == 0) ? false : true;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void b(String str) {
        this.j = str;
    }

    public final String c() {
        return this.i;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.g;
    }

    public final String f() {
        return this.h;
    }

    public u() {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.f = new LinkedList<>();
        this.d = new AntiData();
    }

    public final void a(String str, boolean z) {
        try {
            a(new JSONObject(str), (Boolean) true);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    public final LinkedList<t> g() {
        return this.f;
    }

    public final void c(String str) {
        this.a = str;
    }

    public final String h() {
        return this.a;
    }

    public final String i() {
        return this.b;
    }

    public final int j() {
        return this.c;
    }

    public final String k() {
        return this.f.size() > 0 ? this.f.get(this.f.size() - 1).c() : "";
    }

    private void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                this.k = jSONObject.optInt("is_new_url", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.a = optJSONObject.optString("name");
                    this.b = optJSONObject.optString("id");
                }
                this.c = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            t tVar = new t(this.e);
                            tVar.a(optJSONArray.optJSONObject(i));
                            int h = tVar.h();
                            if (h > 0 && h <= this.c) {
                                this.f.addLast(tVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            t tVar2 = new t(this.e);
                            tVar2.a(optJSONArray.getJSONObject(length));
                            int h2 = tVar2.h();
                            if (h2 > 0 && h2 <= this.c) {
                                this.f.addFirst(tVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.g = optJSONObject2.optString("tid");
                this.h = optJSONObject2.optString("title");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "paserJson", e.toString());
            }
        }
    }

    public final int l() {
        return this.k;
    }
}
