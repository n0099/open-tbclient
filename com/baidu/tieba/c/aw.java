package com.baidu.tieba.c;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw {
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
    final /* synthetic */ av p;
    int a = 0;
    ArrayList e = new ArrayList();
    ArrayList l = new ArrayList();
    com.baidu.tieba.a.ai j = new com.baidu.tieba.a.ai();
    com.baidu.tieba.a.ai o = new com.baidu.tieba.a.ai();

    public aw(av avVar) {
        this.p = avVar;
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

    public com.baidu.tieba.a.ai l() {
        return this.j;
    }

    public com.baidu.tieba.a.ai m() {
        return this.o;
    }

    public void a(com.baidu.tieba.a.ai aiVar) {
        if (aiVar != null) {
            this.o = aiVar;
        }
    }

    public String n() {
        return this.c;
    }

    public String o() {
        return this.d;
    }

    public com.baidu.tieba.a.ae p() {
        if (this.a != 0) {
            return null;
        }
        try {
            com.baidu.tieba.a.ae aeVar = new com.baidu.tieba.a.ae((int) (Double.valueOf(this.d).doubleValue() * 1000000.0d), (int) (Double.valueOf(this.c).doubleValue() * 1000000.0d));
            aeVar.a(this.j);
            aeVar.a(this.g);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.e.size(); i++) {
                if (((com.baidu.tieba.a.k) this.e.get(i)).a() == 0) {
                    stringBuffer.append(((com.baidu.tieba.a.k) this.e.get(i)).d());
                }
                if (((com.baidu.tieba.a.k) this.e.get(i)).a() == 2) {
                    String d = com.baidu.tbadk.a.a.a().d(((com.baidu.tieba.a.k) this.e.get(i)).d());
                    if (d == null) {
                        stringBuffer.append(TiebaApplication.e().getResources().getString(R.string.face_string));
                    } else {
                        stringBuffer.append("[");
                        stringBuffer.append(d);
                        stringBuffer.append("]");
                    }
                }
                if (((com.baidu.tieba.a.k) this.e.get(i)).a() == 3) {
                    stringBuffer.append(TiebaApplication.e().getResources().getString(R.string.pic));
                }
            }
            aeVar.b(stringBuffer.toString());
            return aeVar;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "getMapItem", e.toString());
            return null;
        }
    }

    public String q() {
        return this.k;
    }
}
