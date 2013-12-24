package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.au;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.a.d {
    private String b;
    private String c;
    private int d;
    private boolean g;
    private com.baidu.tieba.im.message.ag j;
    private au k;
    private com.baidu.tieba.im.message.g l;
    private int a = 0;
    private boolean h = false;
    private boolean i = false;
    private int f = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f);
    private int e = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f);

    public boolean a() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean b() {
        return this.g;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public boolean c() {
        return this.h;
    }

    public void c(boolean z) {
        this.h = z;
    }

    private com.baidu.tieba.im.message.ag b(int i) {
        com.baidu.tieba.im.message.ag agVar = new com.baidu.tieba.im.message.ag();
        agVar.b(this.e);
        agVar.a(this.f);
        agVar.b(this.c);
        agVar.a(this.b);
        agVar.d(i * 30);
        agVar.c(30);
        agVar.f(this.d);
        return agVar;
    }

    private au b(long j) {
        au auVar = new au();
        auVar.a(j);
        return auVar;
    }

    public void d() {
        this.a = 0;
        this.d = 0;
        this.j = b(this.a);
        com.baidu.tieba.im.messageCenter.e.a().a(this.j);
    }

    public void e() {
        g();
        this.j = b(this.a);
        com.baidu.tieba.im.messageCenter.e.a().a(this.j);
    }

    public void a(long j) {
        this.k = b(j);
        com.baidu.tieba.im.messageCenter.e.a().a(this.k);
    }

    public void f() {
        this.h = true;
        this.l = new com.baidu.tieba.im.message.g();
        com.baidu.tieba.im.messageCenter.e.a().a(this.l);
    }

    public void g() {
        this.a++;
    }

    public boolean h() {
        if (this.h) {
            if (UtilHelper.b()) {
                d();
                return true;
            }
            return false;
        }
        f();
        return true;
    }

    public void i() {
        if (this.j != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.j);
            this.j = null;
        }
        if (this.k != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.k);
            this.k = null;
        }
        if (this.l != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.l);
            this.l = null;
        }
    }
}
