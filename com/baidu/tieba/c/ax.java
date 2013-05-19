package com.baidu.tieba.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.c {
    private Context h;
    private com.baidu.tieba.a.ax i;
    private String e = null;
    private String f = null;
    private String g = null;
    private ay j = null;
    private az k = null;

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

    public ax(Context context) {
        this.h = null;
        this.i = null;
        this.h = context;
        this.i = new com.baidu.tieba.a.ax();
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
        this.i = new com.baidu.tieba.a.ax();
    }

    public com.baidu.tieba.a.ax f() {
        return this.i;
    }

    public com.baidu.tieba.a.bh g() {
        if (this.i == null || this.i.g() == null || this.i.l() == null || this.i.a() == null) {
            return null;
        }
        com.baidu.tieba.a.bh bhVar = new com.baidu.tieba.a.bh();
        bhVar.f(this.i.g().b());
        bhVar.e(this.i.g().a());
        bhVar.d(this.i.a().d());
        bhVar.a(2);
        bhVar.c(this.i.l().a());
        bhVar.b(0);
        return bhVar;
    }

    public void a(az azVar) {
        this.k = azVar;
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
        if (this.e == null || this.f == null) {
            return false;
        }
        this.j = new ay(this, 0);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
        return true;
    }

    public boolean j() {
        h();
        if (this.e == null || this.f == null || this.i.k()) {
            return false;
        }
        this.j = new ay(this, 2);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
        return true;
    }

    public boolean k() {
        h();
        this.j = new ay(this, 1);
        this.j.setPriority(3);
        this.j.execute(new Object[0]);
        return true;
    }
}
