package com.baidu.tieba.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.c {
    private Context h;
    private com.baidu.tieba.a.ay i;
    private String e = null;
    private String f = null;
    private String g = null;
    private bb j = null;
    private bc k = null;

    public void a(Intent intent) {
        this.e = intent.getStringExtra("thread_id");
        this.f = intent.getStringExtra("post_id");
        this.g = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        this.e = bundle.getString("thread_id");
        this.f = bundle.getString("post_id");
        this.g = bundle.getString("st_type");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.e);
        bundle.putString("post_id", this.f);
        bundle.putString("st_type", this.g);
    }

    public ba(Context context) {
        this.h = null;
        this.i = null;
        this.h = context;
        this.i = new com.baidu.tieba.a.ay();
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public void e() {
        this.i = new com.baidu.tieba.a.ay();
    }

    public com.baidu.tieba.a.ay f() {
        return this.i;
    }

    public com.baidu.tieba.a.bi g() {
        if (this.i == null || this.i.g() == null || this.i.l() == null || this.i.a() == null) {
            return null;
        }
        com.baidu.tieba.a.bi biVar = new com.baidu.tieba.a.bi();
        biVar.f(this.i.g().b());
        biVar.e(this.i.g().a());
        biVar.d(this.i.a().d());
        biVar.a(2);
        biVar.c(this.i.l().a());
        biVar.b(0);
        return biVar;
    }

    public void a(bc bcVar) {
        this.k = bcVar;
    }

    public boolean h() {
        if (this.j != null) {
            this.j.cancel();
            return true;
        }
        return true;
    }

    public boolean i() {
        h();
        if (this.e == null || this.f == null || this.j != null) {
            return false;
        }
        this.j = new bb(this, 0);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
        return true;
    }

    public boolean j() {
        h();
        if (this.e == null || this.f == null || this.i.k() || this.j != null) {
            return false;
        }
        this.j = new bb(this, 2);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
        return true;
    }

    public boolean k() {
        h();
        this.j = new bb(this, 1);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
        return true;
    }
}
