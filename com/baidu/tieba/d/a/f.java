package com.baidu.tieba.d.a;

import com.baidu.tieba.data.an;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class f extends an implements d {
    public boolean a = false;
    public String b;
    public String c;
    public long d;
    private a e;
    private int f;

    @Override // com.baidu.tieba.data.an
    public void a(JSONObject jSONObject) {
        this.e = new a(jSONObject);
    }

    public void a(App app) {
        this.e = new a(app);
    }

    public a p() {
        return this.e;
    }

    public String q() {
        return this.e == null ? "" : this.e.a;
    }

    public int r() {
        return this.f;
    }

    @Override // com.baidu.tieba.d.a.c
    public void a(int i) {
        this.f = i;
    }

    public boolean s() {
        if (this.e == null) {
            return false;
        }
        return this.e.a();
    }

    public boolean t() {
        if (this.e == null) {
            return false;
        }
        return this.e.b();
    }

    public boolean u() {
        if (this.e == null) {
            return false;
        }
        return this.e.c();
    }

    @Override // com.baidu.tieba.d.a.c
    public String a() {
        if (this.e == null) {
            return null;
        }
        return this.e.g;
    }

    @Override // com.baidu.tieba.d.a.c
    public String h_() {
        if (this.e == null) {
            return null;
        }
        return this.e.f;
    }

    @Override // com.baidu.tieba.d.a.c
    public String i_() {
        if (this.e == null || this.e.t == null) {
            return null;
        }
        return this.e.t.d;
    }

    @Override // com.baidu.tieba.d.a.e
    public String j_() {
        if (this.e == null || this.e.t == null) {
            return null;
        }
        return this.e.t.b;
    }

    @Override // com.baidu.tieba.d.a.e
    public String k_() {
        if (this.e == null || this.e.t == null) {
            return null;
        }
        return this.e.t.c;
    }

    @Override // com.baidu.tieba.d.a.e
    public String f() {
        if (this.e == null || this.e.t == null) {
            return null;
        }
        return this.e.t.d;
    }

    @Override // com.baidu.tieba.d.a.e
    public String l_() {
        if (this.e == null || this.e.t == null) {
            return null;
        }
        return this.e.t.e;
    }

    @Override // com.baidu.tieba.d.a.e
    public long m_() {
        if (this.e == null) {
            return 0L;
        }
        return this.e.r * 1000;
    }

    public int v() {
        if (this.e == null || this.e.t == null) {
            return -1;
        }
        return this.e.t.g;
    }

    public int w() {
        int a = this.e != null ? com.baidu.adp.lib.e.c.a(this.e.h, 0) : 0;
        if (a < 2 || a > 30) {
            return 7;
        }
        return a;
    }

    public String x() {
        if (this.e == null || this.e.t == null) {
            return null;
        }
        return this.e.t.f;
    }

    public com.baidu.tbadk.core.data.a y() {
        com.baidu.tbadk.core.data.a aVar = new com.baidu.tbadk.core.data.a();
        if (this.e != null) {
            aVar.b = this.e.a;
            aVar.c = this.e.b;
            aVar.d = this.e.c;
            aVar.e = this.e.d;
            aVar.f = this.e.f;
            aVar.g = this.e.g;
            try {
                aVar.h = Integer.parseInt(this.e.h.trim());
            } catch (Exception e) {
                aVar.h = -1;
            }
            aVar.i = this.e.i;
            aVar.j = this.e.j;
            aVar.k = this.e.l;
            aVar.m = this.e.m;
            aVar.n = this.e.n;
            aVar.o = this.e.o;
            aVar.p = this.e.p;
            aVar.l = this.e.k;
            aVar.q = this.e.q;
            aVar.r = this.e.r * 1000;
            if (this.e.t != null) {
                aVar.s.f = this.e.t.f;
                aVar.s.a = this.e.t.a;
                aVar.s.e = this.e.t.e;
                aVar.s.g = this.e.t.g;
                aVar.s.d = this.e.t.d;
                aVar.s.b = this.e.t.b;
                aVar.s.c = this.e.t.c;
            }
        }
        return aVar;
    }
}
