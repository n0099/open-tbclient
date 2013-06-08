package com.baidu.tieba.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.c {
    private String e;
    private String f;
    private com.baidu.tieba.a.a.c l;
    private com.baidu.tieba.a.a.f p;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private x m = null;
    private z n = null;
    private y o = null;

    public void a(Intent intent) {
        this.i = intent.getStringExtra("chat_com_name");
        this.h = intent.getStringExtra("chat_com_id");
        this.k = intent.getStringExtra("chat_st_type");
        this.g = intent.getStringExtra("chat_my_portrait");
        this.j = intent.getStringExtra("chat_com_portrait");
        p();
    }

    public void a(Bundle bundle) {
        this.i = bundle.getString("chat_com_name");
        this.h = bundle.getString("chat_com_id");
        this.k = bundle.getString("chat_st_type");
        this.g = bundle.getString("chat_my_portrait");
        this.j = bundle.getString("chat_com_portrait");
        p();
    }

    public void b(Bundle bundle) {
        bundle.putString("chat_com_name", this.i);
        bundle.putString("chat_com_id", this.h);
        bundle.putString("chat_st_type", this.k);
        bundle.putString("chat_my_portrait", this.g);
        bundle.putString("chat_com_portrait", this.j);
    }

    public w() {
        this.e = null;
        this.f = null;
        this.l = null;
        this.p = null;
        com.baidu.tieba.a.a E = TiebaApplication.E();
        if (E != null) {
            this.f = E.a();
            this.e = E.b();
        }
        this.l = new com.baidu.tieba.a.a.c();
        this.p = com.baidu.tieba.a.a.f.a();
    }

    private void p() {
        this.l.a(this.h);
        this.l.b(this.f);
        this.l.f(this.i);
        this.l.c(this.j);
        this.l.d(this.g);
    }

    public void a(y yVar) {
        this.o = yVar;
    }

    public com.baidu.tieba.a.a.c d() {
        return this.l;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.f;
    }

    public long g() {
        if (this.l.f() == null) {
            return 0L;
        }
        return this.l.f().b();
    }

    public String h() {
        if (this.l != null) {
            return this.l.b();
        }
        return null;
    }

    public String i() {
        if (this.l != null) {
            return this.l.a();
        }
        return null;
    }

    public boolean j() {
        if (this.f == null || this.h == null) {
            return false;
        }
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.m != null) {
            this.m.cancel();
        }
        this.n = new z(this);
        this.n.execute(new Object[0]);
        return true;
    }

    public void k() {
        this.p.b(this.f, this.h);
    }

    public boolean l() {
        if (this.f == null || this.h == null || this.n != null) {
            return false;
        }
        this.m = new x(this, 2);
        this.m.execute(new Object[0]);
        return true;
    }

    public boolean m() {
        if (this.f == null || this.h == null || this.n != null) {
            return false;
        }
        if (this.m != null) {
            this.m.cancel();
        }
        this.m = new x(this, 0);
        this.m.execute(new Object[0]);
        return true;
    }

    public boolean n() {
        if (this.f == null || this.h == null || this.n != null) {
            return false;
        }
        if (this.m != null) {
            this.m.cancel();
        }
        this.m = new x(this, 1);
        this.m.execute(new Object[0]);
        return true;
    }

    public boolean o() {
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.m != null) {
            this.m.cancel();
            return false;
        }
        return false;
    }
}
