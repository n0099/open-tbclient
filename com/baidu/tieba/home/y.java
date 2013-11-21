package com.baidu.tieba.home;

import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private int f1460a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private String i;
    private int j;
    private ArrayList<z> k = new ArrayList<>();
    private ArrayList<z> l = new ArrayList<>();
    private ArrayList<z> m = new ArrayList<>();
    private HashMap<String, z> n = new HashMap<>();
    private r o = new r();
    private int p;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public String h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public ArrayList<z> j() {
        return this.k;
    }

    public r k() {
        return this.o;
    }

    public ArrayList<z> l() {
        return this.l;
    }

    public ArrayList<z> m() {
        return this.m;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void a(bp bpVar) {
        ArrayList<bq> d = bpVar.d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            bq bqVar = d.get(i);
            String str = bqVar.a() + "";
            z zVar = this.n.get(str);
            if (zVar != null) {
                if (bqVar.b() != 0) {
                    this.n.remove(str);
                    this.m.remove(zVar);
                    zVar.a(1);
                    zVar.b(bqVar.c());
                    zVar.d(bqVar.d());
                    zVar.a(true);
                    zVar.b(false);
                    zVar.c(false);
                    if (zVar.g() + zVar.m() >= zVar.h()) {
                        zVar.c(zVar.f() + 1);
                        zVar.e(true);
                    }
                    this.l.add(zVar);
                    TiebaApplication.g().a(zVar.b(), zVar.m());
                } else {
                    zVar.a(false);
                    zVar.b(true);
                    zVar.c(false);
                    zVar.a(bqVar.e().b());
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.o.a(jSONObject.optJSONObject("error"));
                this.f1460a = jSONObject.optInt("level");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optString("text_pre");
                this.d = jSONObject.optString("text_color");
                this.e = jSONObject.optString("text_mid");
                this.f = jSONObject.optString("text_suf");
                this.g = jSONObject.optString("num_notice");
                this.h = jSONObject.optInt("show_dialog");
                this.i = jSONObject.optString("sign_notice");
                this.j = jSONObject.optInt("valid");
                this.p = jSONObject.optInt("sign_max_num");
                bx.f1432a = this.p;
                JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
                if (optJSONArray != null) {
                    int min = Math.min(optJSONArray.length(), bx.f1432a);
                    for (int i = 0; i < min; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            z zVar = new z();
                            zVar.a(jSONObject2);
                            if (zVar.d() == 0) {
                                if (this.j == 0) {
                                    zVar.b(true);
                                }
                                this.m.add(zVar);
                                this.n.put(zVar.a() + "", zVar);
                            } else {
                                this.l.add(zVar);
                                TiebaApplication.g().a(zVar.b(), zVar.m());
                            }
                            this.k.add(zVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
