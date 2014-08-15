package com.baidu.tieba.d.a;

import com.baidu.tieba.data.an;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class f extends an implements d {
    public boolean a = false;
    public String b;
    public long c;
    private a d;
    private int e;

    @Override // com.baidu.tieba.data.an
    public void a(JSONObject jSONObject) {
        this.d = new a(jSONObject);
    }

    public void a(App app) {
        this.d = new a(app);
    }

    public a p() {
        return this.d;
    }

    public String q() {
        return this.d == null ? "" : this.d.a;
    }

    public int r() {
        return this.e;
    }

    @Override // com.baidu.tieba.d.a.c
    public void a(int i) {
        this.e = i;
    }

    public boolean s() {
        if (this.d == null) {
            return false;
        }
        return this.d.a();
    }

    public boolean t() {
        if (this.d == null) {
            return false;
        }
        return this.d.b();
    }

    public boolean u() {
        if (this.d == null) {
            return false;
        }
        return this.d.c();
    }

    @Override // com.baidu.tieba.d.a.c
    public String a() {
        if (this.d == null) {
            return null;
        }
        return this.d.g;
    }

    @Override // com.baidu.tieba.d.a.c
    public String h_() {
        if (this.d == null) {
            return null;
        }
        return this.d.f;
    }

    @Override // com.baidu.tieba.d.a.c
    public String i_() {
        if (this.d == null || this.d.t == null) {
            return null;
        }
        return this.d.t.d;
    }

    @Override // com.baidu.tieba.d.a.e
    public String j_() {
        if (this.d == null || this.d.t == null) {
            return null;
        }
        return this.d.t.b;
    }

    @Override // com.baidu.tieba.d.a.e
    public String k_() {
        if (this.d == null || this.d.t == null) {
            return null;
        }
        return this.d.t.c;
    }

    @Override // com.baidu.tieba.d.a.e
    public String f() {
        if (this.d == null || this.d.t == null) {
            return null;
        }
        return this.d.t.d;
    }

    @Override // com.baidu.tieba.d.a.e
    public String l_() {
        if (this.d == null || this.d.t == null) {
            return null;
        }
        return this.d.t.e;
    }

    @Override // com.baidu.tieba.d.a.e
    public long m_() {
        if (this.d == null) {
            return 0L;
        }
        return this.d.r * 1000;
    }

    public int v() {
        if (this.d == null || this.d.t == null) {
            return -1;
        }
        return this.d.t.g;
    }

    public int w() {
        if (this.d == null) {
            return 0;
        }
        return com.baidu.adp.lib.e.b.a(this.d.h, 0);
    }

    public String x() {
        if (this.d == null || this.d.t == null) {
            return null;
        }
        return this.d.t.f;
    }

    public com.baidu.tbadk.core.data.a y() {
        com.baidu.tbadk.core.data.a aVar = new com.baidu.tbadk.core.data.a();
        if (this.d != null) {
            aVar.b = this.d.a;
            aVar.c = this.d.b;
            aVar.d = this.d.c;
            aVar.e = this.d.d;
            aVar.f = this.d.f;
            aVar.g = this.d.g;
            try {
                aVar.h = Integer.parseInt(this.d.h.trim());
            } catch (Exception e) {
                aVar.h = -1;
            }
            aVar.i = this.d.i;
            aVar.j = this.d.j;
            aVar.k = this.d.l;
            aVar.m = this.d.m;
            aVar.n = this.d.n;
            aVar.o = this.d.o;
            aVar.p = this.d.p;
            aVar.l = this.d.k;
            aVar.q = this.d.q;
            aVar.r = this.d.r * 1000;
            if (this.d.t != null) {
                aVar.s.f = this.d.t.f;
                aVar.s.a = this.d.t.a;
                aVar.s.e = this.d.t.e;
                aVar.s.g = this.d.t.g;
                aVar.s.d = this.d.t.d;
                aVar.s.b = this.d.t.b;
                aVar.s.c = this.d.t.c;
            }
        }
        return aVar;
    }
}
