package com.baidu.tieba.b;

import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.ab;
import com.baidu.tieba.a.af;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p {
    String b;
    String c;
    String d;
    String f;
    String g;
    String h;
    String i;
    String k;
    int m;
    String n;
    final /* synthetic */ o p;
    int a = 0;
    ArrayList e = new ArrayList();
    ArrayList l = new ArrayList();
    af j = new af();
    af o = new af();

    public p(o oVar) {
        this.p = oVar;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public ArrayList c() {
        return this.e;
    }

    public int d() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public String e() {
        return this.n;
    }

    public void a(String str) {
        if (str != null) {
            this.n = str;
        }
    }

    public String f() {
        return this.f;
    }

    public String g() {
        if (this.e == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return null;
            }
            if (((com.baidu.tieba.a.k) this.e.get(i2)).a() != 3) {
                i = i2 + 1;
            } else {
                return ((com.baidu.tieba.a.k) this.e.get(i2)).f();
            }
        }
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.i;
    }

    public ArrayList k() {
        return this.l;
    }

    public void a(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            this.l.clear();
            this.l = arrayList;
        }
    }

    public af l() {
        return this.j;
    }

    public af m() {
        return this.o;
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.o = afVar;
        }
    }

    public String n() {
        return this.c;
    }

    public String o() {
        return this.d;
    }

    public ab p() {
        if (this.a != 0) {
            return null;
        }
        try {
            ab abVar = new ab((int) (Double.valueOf(this.d).doubleValue() * 1000000.0d), (int) (Double.valueOf(this.c).doubleValue() * 1000000.0d));
            abVar.a(this.j);
            abVar.a(this.g);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.e.size(); i++) {
                if (((com.baidu.tieba.a.k) this.e.get(i)).a() == 0) {
                    stringBuffer.append(((com.baidu.tieba.a.k) this.e.get(i)).d());
                }
                if (((com.baidu.tieba.a.k) this.e.get(i)).a() == 2) {
                    String a = com.baidu.tieba.c.n.a(((com.baidu.tieba.a.k) this.e.get(i)).d());
                    if (a == null) {
                        stringBuffer.append(TiebaApplication.b().getResources().getString(R.string.face_string));
                    } else {
                        stringBuffer.append("(");
                        stringBuffer.append(a);
                        stringBuffer.append(")");
                    }
                }
                if (((com.baidu.tieba.a.k) this.e.get(i)).a() == 3) {
                    stringBuffer.append(TiebaApplication.b().getResources().getString(R.string.pic));
                }
            }
            abVar.b(stringBuffer.toString());
            return abVar;
        } catch (Exception e) {
            ag.b(getClass().getName(), "getMapItem", e.toString());
            return null;
        }
    }

    public String q() {
        return this.k;
    }
}
