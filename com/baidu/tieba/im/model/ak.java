package com.baidu.tieba.im.model;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.bl;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public final class ak extends com.baidu.adp.a.d {
    private String b;
    private String c;
    private int d;
    private boolean g;
    private at j;
    private bl k;
    private com.baidu.tieba.im.message.k l;
    private int a = 0;
    private boolean h = false;
    private boolean i = false;
    private int f = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
    private int e = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);

    public final boolean a() {
        return this.i;
    }

    public final void a(boolean z) {
        this.i = false;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final boolean b() {
        return this.g;
    }

    public final void b(boolean z) {
        this.g = z;
    }

    public final void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final boolean c() {
        return this.h;
    }

    public final void c(boolean z) {
        this.h = true;
    }

    private at b(int i) {
        at atVar = new at();
        atVar.b(this.e);
        atVar.a(this.f);
        atVar.b(this.c);
        atVar.a(this.b);
        atVar.d(i * 30);
        atVar.c(30);
        atVar.f(this.d);
        return atVar;
    }

    public final void d() {
        this.a = 0;
        this.d = 0;
        this.j = b(this.a);
        com.baidu.tieba.im.messageCenter.d.a().a(this.j);
    }

    public final void e() {
        g();
        this.j = b(this.a);
        com.baidu.tieba.im.messageCenter.d.a().a(this.j);
    }

    public final void a(long j) {
        bl blVar = new bl();
        blVar.a(0L);
        this.k = blVar;
        com.baidu.tieba.im.messageCenter.d.a().a(this.k);
    }

    public final void f() {
        this.h = true;
        this.l = new com.baidu.tieba.im.message.k();
        com.baidu.tieba.im.messageCenter.d.a().a(this.l);
    }

    public final void g() {
        this.a++;
    }

    public final boolean h() {
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

    public final void i() {
        if (this.j != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.j);
            this.j = null;
        }
        if (this.k != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.k);
            this.k = null;
        }
        if (this.l != null) {
            com.baidu.tieba.im.messageCenter.d.a().b(this.l);
            this.l = null;
        }
    }
}
