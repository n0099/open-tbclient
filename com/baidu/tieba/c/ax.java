package com.baidu.tieba.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.c {
    private static final int e = com.baidu.tieba.a.i.b() / 30;
    private static com.baidu.tieba.a.an z = new com.baidu.tieba.a.an();
    private Context A;
    private com.baidu.tieba.a.am x;
    private String f = null;
    private String g = null;
    private String h = null;
    private boolean i = false;
    private boolean j = true;
    private int k = 0;
    private int l = 0;
    private long m = 0;
    private int n = 1;
    private int o = 1;
    private int p = 1;
    private int q = 1;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private long v = 0;
    private boolean w = false;
    private az y = null;
    private ay B = null;
    private long C = 0;

    public ax(Context context) {
        this.x = null;
        this.A = null;
        this.x = new com.baidu.tieba.a.am();
        z.a();
        this.A = context;
    }

    public void a(Intent intent) {
        this.g = intent.getStringExtra("thread_id");
        this.h = intent.getStringExtra("post_id");
        this.i = intent.getBooleanExtra("host_only", false);
        this.j = intent.getBooleanExtra("squence", true);
        this.f = intent.getStringExtra("st_type");
        this.k = intent.getIntExtra("is_good", 0);
        this.l = intent.getIntExtra("is_top", 0);
        this.m = intent.getLongExtra("thread_time", 0L);
        this.t = intent.getBooleanExtra("from_frs", false);
        this.u = intent.getBooleanExtra("from_mark", false);
        this.r = intent.getBooleanExtra("is_ad", false);
        this.s = intent.getBooleanExtra("is_sub_pb", false);
        this.w = intent.getBooleanExtra("is_pv", false);
        this.v = intent.getLongExtra("msg_id", 0L);
    }

    public void a(Bundle bundle) {
        this.g = bundle.getString("thread_id");
        this.h = bundle.getString("post_id");
        this.i = bundle.getBoolean("host_only", false);
        this.j = bundle.getBoolean("squence", true);
        this.f = bundle.getString("st_type");
        this.k = bundle.getInt("is_good", 0);
        this.l = bundle.getInt("is_top", 0);
        this.m = bundle.getLong("thread_time");
        this.t = bundle.getBoolean("from_frs", false);
        this.u = bundle.getBoolean("from_mark", false);
        this.r = bundle.getBoolean("is_ad", false);
        this.s = bundle.getBoolean("is_sub_pb", false);
        this.w = bundle.getBoolean("is_pv", false);
        this.v = bundle.getLong("msg_id", 0L);
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.g);
        bundle.putString("post_id", this.h);
        bundle.putBoolean("host_only", this.i);
        bundle.putBoolean("squence", this.j);
        bundle.putString("st_type", this.f);
        bundle.putInt("is_good", this.k);
        bundle.putInt("is_top", this.l);
        bundle.putLong("thread_time", this.m);
        bundle.putBoolean("from_frs", this.t);
        bundle.putBoolean("from_mark", this.u);
        bundle.putBoolean("is_sub_pb", this.s);
        bundle.putBoolean("is_ad", this.r);
        bundle.putBoolean("is_pv", this.w);
        bundle.putLong("msg_id", this.v);
    }

    public String d() {
        return this.g;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public boolean g() {
        return this.t;
    }

    public boolean h() {
        return this.u;
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c(int i) {
        this.l = i;
    }

    public boolean k() {
        return this.s;
    }

    public String l() {
        if (this.x == null || !this.x.g()) {
            return null;
        }
        return this.x.h();
    }

    public boolean d(int i) {
        this.n = i;
        if (this.n > this.x.e().a()) {
            this.n = this.x.e().a();
        }
        if (this.n < 1) {
            this.n = 1;
        }
        if (this.g == null) {
            return false;
        }
        if (this.y != null) {
            this.y.cancel();
        }
        this.y = new az(this, 5);
        this.y.setPriority(3);
        this.y.execute(new Object[0]);
        return true;
    }

    public void e(int i) {
        this.n = i;
        this.o = i;
        this.p = i;
    }

    public void f(int i) {
        if (this.o < i) {
            this.o = i;
            if (this.o - this.p >= e) {
                this.p = (this.o - e) + 1;
            }
        }
        if (this.p > i) {
            this.p = i;
            if (this.o - this.p >= e) {
                this.o = (this.p + e) - 1;
            }
        }
    }

    public com.baidu.tieba.a.am m() {
        return this.x;
    }

    public com.baidu.tieba.a.al n() {
        if (this.x == null) {
            return null;
        }
        return this.x.e();
    }

    public boolean o() {
        if (this.j) {
            if (this.x.e().f() == 0) {
                a(true);
                return true;
            }
        } else if (this.x.e().g() == 0) {
            b(true);
            return true;
        }
        return false;
    }

    protected boolean p() {
        if (this.g == null) {
            return false;
        }
        if (this.y != null) {
            this.y.cancel();
        }
        this.y = new az(this, 3);
        this.y.setPriority(3);
        this.y.execute(new Object[0]);
        return true;
    }

    public boolean q() {
        if (this.y != null) {
            this.y.cancel();
            return true;
        }
        return true;
    }

    public boolean r() {
        return (this.h == null || this.h.equals("0")) ? p() : s();
    }

    public boolean s() {
        if (this.g == null || this.h == null) {
            return false;
        }
        if (this.y != null) {
            this.y.cancel();
        }
        if (this.u) {
            this.y = new az(this, 4);
        } else {
            this.y = new az(this, 6);
        }
        this.y.setPriority(3);
        this.y.execute(new Object[0]);
        return true;
    }

    public boolean a(boolean z2) {
        if (this.g == null || this.x == null) {
            return false;
        }
        if ((z2 || this.x.e().f() != 0) && this.y == null) {
            this.y = new az(this, 1);
            this.y.setPriority(3);
            this.y.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean b(boolean z2) {
        if (this.g == null || this.x == null) {
            return false;
        }
        if ((z2 || this.x.e().g() != 0) && this.y == null) {
            this.y = new az(this, 2);
            this.y.setPriority(3);
            this.y.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean t() {
        this.i = !this.i;
        if (this.i) {
            this.j = true;
        }
        p();
        return true;
    }

    public boolean u() {
        this.j = !this.j;
        if (!this.j) {
            this.i = false;
        }
        p();
        return true;
    }

    public void v() {
        if (this.x != null && this.x.a() != null && this.x.b() != null) {
            if (TiebaApplication.d().o()) {
                StatService.onEvent(this.A, "pb_share", "pbclick", 1);
            }
            String b = this.x.a().b();
            com.baidu.tieba.d.ag.a(this.A, "client_share", this.g, this.x.b().b(), b);
        }
    }

    public boolean w() {
        if (this.x == null) {
            return false;
        }
        return this.x.g();
    }

    public com.baidu.tieba.a.bi b(String str) {
        if (this.x == null) {
            return null;
        }
        com.baidu.tieba.a.bi biVar = new com.baidu.tieba.a.bi();
        biVar.e(this.x.a().a());
        biVar.f(this.x.a().b());
        biVar.c(this.g);
        biVar.a(this.r);
        if (str == null) {
            biVar.a(1);
            return biVar;
        }
        biVar.a(2);
        biVar.d(str);
        biVar.b(0);
        return biVar;
    }

    public com.baidu.tieba.a.ay a(com.baidu.tieba.a.ar arVar) {
        if (arVar == null) {
            return null;
        }
        com.baidu.tieba.a.ay ayVar = new com.baidu.tieba.a.ay();
        ayVar.a(this.x.a());
        ayVar.a(this.x.b());
        ayVar.a(arVar);
        ayVar.a(arVar.a());
        ayVar.b(arVar.k());
        String h = this.x.h();
        String d = arVar.d();
        if (w() && h != null && d != null && h.equals(d)) {
            ayVar.a(true);
            return ayVar;
        }
        ayVar.a(false);
        return ayVar;
    }

    public com.baidu.tieba.a.af g(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.x == null || this.x.d() == null) {
            return null;
        }
        ArrayList d = this.x.d();
        if (d.size() <= 0 || i >= d.size()) {
            return null;
        }
        return b((com.baidu.tieba.a.ar) d.get(i));
    }

    public com.baidu.tieba.a.af b(com.baidu.tieba.a.ar arVar) {
        com.baidu.tieba.a.af afVar = new com.baidu.tieba.a.af();
        Date date = new Date();
        afVar.e(TiebaApplication.B());
        afVar.h(this.g);
        afVar.d(arVar.d());
        afVar.a(date.getTime());
        afVar.a(this.i);
        afVar.a(Boolean.valueOf(this.j));
        afVar.b(this.g);
        afVar.c(arVar.f());
        return afVar;
    }

    public void c(boolean z2) {
        if (this.x != null) {
            this.x.a(z2);
        }
    }

    public void a(ay ayVar) {
        this.B = ayVar;
    }
}
