package com.baidu.tieba.home;

import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
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
    private ArrayList<v> k = new ArrayList<>();
    private ArrayList<v> l = new ArrayList<>();
    private ArrayList<v> m = new ArrayList<>();
    private HashMap<String, v> n = new HashMap<>();
    private n o = new n();
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

    public ArrayList<v> j() {
        return this.k;
    }

    public n k() {
        return this.o;
    }

    public ArrayList<v> l() {
        return this.l;
    }

    public ArrayList<v> m() {
        return this.m;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public void a(bl blVar) {
        ArrayList<bm> d = blVar.d();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            bm bmVar = d.get(i);
            String str = bmVar.a() + "";
            v vVar = this.n.get(str);
            if (vVar != null) {
                if (bmVar.b() != 0) {
                    this.n.remove(str);
                    this.m.remove(vVar);
                    vVar.a(1);
                    vVar.b(bmVar.c());
                    vVar.d(bmVar.d());
                    vVar.a(true);
                    vVar.b(false);
                    vVar.c(false);
                    if (vVar.g() + vVar.m() >= vVar.h()) {
                        vVar.c(vVar.f() + 1);
                        vVar.e(true);
                    }
                    this.l.add(vVar);
                    TiebaApplication.g().a(vVar.b(), vVar.m(), -1);
                } else {
                    vVar.a(false);
                    vVar.b(true);
                    vVar.c(false);
                    vVar.a(bmVar.e().b());
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
                bu.a = this.p;
                JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
                if (optJSONArray != null) {
                    int min = Math.min(optJSONArray.length(), bu.a);
                    for (int i = 0; i < min; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            v vVar = new v();
                            vVar.a(jSONObject2);
                            if (vVar.d() == 0) {
                                if (this.j == 0) {
                                    vVar.b(true);
                                }
                                this.m.add(vVar);
                                this.n.put(vVar.a() + "", vVar);
                            } else {
                                this.l.add(vVar);
                                TiebaApplication.g().a(vVar.b(), vVar.m(), -1);
                            }
                            this.k.add(vVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
