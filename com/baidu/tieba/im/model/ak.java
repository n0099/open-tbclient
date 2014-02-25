package com.baidu.tieba.im.model;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.bl;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.a.d {
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

    private bl b(long j) {
        bl blVar = new bl();
        blVar.a(j);
        return blVar;
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
        this.l = new com.baidu.tieba.im.message.k();
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
