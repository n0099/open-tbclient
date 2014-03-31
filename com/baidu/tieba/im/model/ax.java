package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class ax extends com.baidu.adp.a.e {
    private String b;
    private String c;
    private int d;
    private boolean g;
    private com.baidu.tieba.im.message.aq j;
    private com.baidu.tieba.im.message.bk k;
    private com.baidu.tieba.im.message.d l;
    private int a = 0;
    private boolean h = false;
    private boolean i = false;
    private int f = com.baidu.adp.lib.util.i.a(TbadkApplication.j().c(), 70.0f);
    private int e = com.baidu.adp.lib.util.i.a(TbadkApplication.j().c(), 70.0f);

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

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final boolean c() {
        return this.h;
    }

    public final void c(boolean z) {
        this.h = true;
    }

    private com.baidu.tieba.im.message.aq b(int i) {
        com.baidu.tieba.im.message.aq aqVar = new com.baidu.tieba.im.message.aq();
        aqVar.e(this.e);
        aqVar.d(this.f);
        aqVar.b(this.c);
        aqVar.a(this.b);
        aqVar.h(i * 30);
        aqVar.f(30);
        aqVar.i(this.d);
        return aqVar;
    }

    public final void d() {
        this.a = 0;
        this.d = 0;
        this.j = b(this.a);
        super.sendMessage(this.j);
    }

    public final void e() {
        g();
        this.j = b(this.a);
        super.sendMessage(this.j);
    }

    public final void a(long j) {
        com.baidu.tieba.im.message.bk bkVar = new com.baidu.tieba.im.message.bk();
        bkVar.b(0L);
        this.k = bkVar;
        super.sendMessage(this.k);
    }

    public final void f() {
        this.h = true;
        this.l = new com.baidu.tieba.im.message.d();
        super.sendMessage(this.l);
    }

    public final void g() {
        this.a++;
    }

    public final boolean h() {
        if (this.h) {
            if (UtilHelper.a()) {
                d();
                return true;
            }
            return false;
        }
        f();
        return true;
    }

    @Override // com.baidu.adp.a.e
    public final void cancelMessage() {
        super.cancelMessage();
        this.j = null;
        this.k = null;
        this.l = null;
    }
}
