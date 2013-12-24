package com.baidu.tieba.home;

import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private String i;
    private int j;
    private ArrayList<u> k = new ArrayList<>();
    private ArrayList<u> l = new ArrayList<>();
    private ArrayList<u> m = new ArrayList<>();
    private HashMap<String, u> n = new HashMap<>();
    private m o = new m();
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

    public ArrayList<u> j() {
        return this.k;
    }

    public m k() {
        return this.o;
    }

    public ArrayList<u> l() {
        return this.l;
    }

    public ArrayList<u> m() {
        return this.m;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void a(bk bkVar) {
        ArrayList<bl> d = bkVar.d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            bl blVar = d.get(i);
            String str = blVar.a() + "";
            u uVar = this.n.get(str);
            if (uVar != null) {
                if (blVar.b() != 0) {
                    this.n.remove(str);
                    this.m.remove(uVar);
                    uVar.a(1);
                    uVar.b(blVar.c());
                    uVar.d(blVar.d());
                    uVar.a(true);
                    uVar.b(false);
                    uVar.c(false);
                    if (uVar.g() + uVar.m() >= uVar.h()) {
                        uVar.c(uVar.f() + 1);
                        uVar.e(true);
                    }
                    this.l.add(uVar);
                    TiebaApplication.h().a(uVar.b(), uVar.m(), -1);
                } else {
                    uVar.a(false);
                    uVar.b(true);
                    uVar.c(false);
                    uVar.a(blVar.e().b());
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.o.a(jSONObject.optJSONObject("error"));
                this.a = jSONObject.optInt("level");
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
                bs.a = this.p;
                JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
                if (optJSONArray != null) {
                    int min = Math.min(optJSONArray.length(), bs.a);
                    for (int i = 0; i < min; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            u uVar = new u();
                            uVar.a(jSONObject2);
                            if (uVar.d() == 0) {
                                if (this.j == 0) {
                                    uVar.b(true);
                                }
                                this.m.add(uVar);
                                this.n.put(uVar.a() + "", uVar);
                            } else {
                                this.l.add(uVar);
                                TiebaApplication.h().a(uVar.b(), uVar.m(), -1);
                            }
                            this.k.add(uVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
