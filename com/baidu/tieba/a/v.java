package com.baidu.tieba.a;

import android.content.Context;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
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

    public v(Context context) {
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

    public boolean a() {
        return this.c > 0 && this.c <= this.f.size();
    }

    public boolean b() {
        return (this.g == null || this.g.length() == 0 || this.h == null || this.h.length() == 0) ? false : true;
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.j = str;
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

    public v() {
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

    public void a(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "paserJson", e.toString());
        }
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
        return this.f.size() > 0 ? ((u) this.f.get(this.f.size() - 1)).c() : "";
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.a = optJSONObject.getString("name");
                    this.b = optJSONObject.optLong("id");
                }
                this.c = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            u uVar = new u(this.e);
                            uVar.a(optJSONArray.getJSONObject(i));
                            int h = uVar.h();
                            if (h >= 1 && h <= this.c) {
                                this.f.addLast(uVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            u uVar2 = new u(this.e);
                            uVar2.a(optJSONArray.getJSONObject(length));
                            int h2 = uVar2.h();
                            if (h2 >= 1 && h2 <= this.c) {
                                this.f.addFirst(uVar2);
                            }
                        }
                    }
                }
                JSONObject jSONObject2 = jSONObject.getJSONArray("album_list").getJSONObject(0);
                this.g = jSONObject2.optString("tid");
                this.h = jSONObject2.optString("title");
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "paserJson", e.toString());
            }
        }
    }
}
