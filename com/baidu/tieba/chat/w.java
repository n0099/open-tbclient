package com.baidu.tieba.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private String f952a;
    private String b;
    private com.baidu.tieba.data.a.c h;
    private com.baidu.tieba.data.a.f l;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private x i = null;
    private z j = null;
    private y k = null;

    public void a(Intent intent) {
        this.e = intent.getStringExtra("chat_com_name");
        this.d = intent.getStringExtra("chat_com_id");
        this.g = intent.getStringExtra("chat_st_type");
        this.c = intent.getStringExtra("chat_my_portrait");
        this.f = intent.getStringExtra("chat_com_portrait");
        l();
    }

    public void a(Bundle bundle) {
        this.e = bundle.getString("chat_com_name");
        this.d = bundle.getString("chat_com_id");
        this.g = bundle.getString("chat_st_type");
        this.c = bundle.getString("chat_my_portrait");
        this.f = bundle.getString("chat_com_portrait");
        l();
    }

    public void b(Bundle bundle) {
        bundle.putString("chat_com_name", this.e);
        bundle.putString("chat_com_id", this.d);
        bundle.putString("chat_st_type", this.g);
        bundle.putString("chat_my_portrait", this.c);
        bundle.putString("chat_com_portrait", this.f);
    }

    public w() {
        this.f952a = null;
        this.b = null;
        this.h = null;
        this.l = null;
        AccountData H = TiebaApplication.H();
        if (H != null) {
            this.b = H.getID();
            this.f952a = H.getAccount();
        }
        this.h = new com.baidu.tieba.data.a.c();
        this.l = com.baidu.tieba.data.a.f.a();
    }

    private void l() {
        this.h.a(this.d);
        this.h.b(this.b);
        this.h.f(this.e);
        this.h.c(this.f);
        this.h.d(this.c);
    }

    public void a(y yVar) {
        this.k = yVar;
    }

    public com.baidu.tieba.data.a.c a() {
        return this.h;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public long d() {
        if (this.h.f() == null) {
            return 0L;
        }
        return this.h.f().b();
    }

    public String e() {
        if (this.h != null) {
            return this.h.b();
        }
        return null;
    }

    public String f() {
        if (this.h != null) {
            return this.h.a();
        }
        return null;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return true;
    }

    public boolean g() {
        if (this.b == null || this.d == null) {
            return false;
        }
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.j = new z(this);
        this.j.execute(new Object[0]);
        return true;
    }

    public void h() {
        this.l.b(this.b, this.d);
    }

    public boolean i() {
        if (this.b == null || this.d == null || this.j != null) {
            return false;
        }
        this.i = new x(this, 2);
        this.i.execute(new Object[0]);
        return true;
    }

    public boolean j() {
        if (this.b == null || this.d == null || this.j != null) {
            return false;
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new x(this, 0);
        this.i.execute(new Object[0]);
        return true;
    }

    public boolean k() {
        if (this.b == null || this.d == null || this.j != null) {
            return false;
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new x(this, 1);
        this.i.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
            return false;
        }
        return false;
    }
}
