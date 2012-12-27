package com.baidu.tieba.a;

import android.content.Context;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private String a;
    private long b;
    private int c;
    private b d;
    private Context e;
    private LinkedList f;
    private String g;
    private String h;
    private String i;
    private String j;

    public u() {
        this.a = null;
        this.b = 0L;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.f = new LinkedList();
        this.d = new b();
    }

    public u(Context context) {
        this.a = null;
        this.b = 0L;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.e = context;
        this.f = new LinkedList();
        this.d = new b();
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            if (optJSONObject != null) {
                this.a = optJSONObject.getString("name");
                this.b = optJSONObject.optLong("id");
            }
            this.c = jSONObject.optInt("pic_amount", 0);
            JSONArray jSONArray = jSONObject.getJSONArray("pic_list");
            if (bool.booleanValue()) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    t tVar = new t(this.e);
                    tVar.a(jSONArray.getJSONObject(i));
                    int h = tVar.h();
                    if (h >= 1 && h <= this.c) {
                        this.f.addLast(tVar);
                    }
                }
            } else {
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    t tVar2 = new t(this.e);
                    tVar2.a(jSONArray.getJSONObject(length));
                    int h2 = tVar2.h();
                    if (h2 >= 1 && h2 <= this.c) {
                        this.f.addFirst(tVar2);
                    }
                }
            }
            JSONObject jSONObject2 = jSONObject.getJSONArray("album_list").getJSONObject(0);
            this.g = jSONObject2.optString("tid");
            this.h = jSONObject2.optString("title");
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    public boolean a() {
        return this.c > 0 && this.c <= this.f.size();
    }

    public void b(String str) {
        this.j = str;
    }

    public boolean b() {
        return (this.g == null || this.g.length() == 0 || this.h == null || this.h.length() == 0) ? false : true;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.j;
    }

    public b e() {
        return this.d;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public LinkedList h() {
        return this.f;
    }

    public String i() {
        return this.a;
    }

    public long j() {
        return this.b;
    }

    public int k() {
        return this.c;
    }

    public String l() {
        return this.f.size() > 0 ? ((t) this.f.get(this.f.size() - 1)).c() : "";
    }
}
