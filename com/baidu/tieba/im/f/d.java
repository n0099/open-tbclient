package com.baidu.tieba.im.f;

import com.baidu.tieba.im.model.bo;
/* loaded from: classes.dex */
public final class d {
    private bo d;
    private g e;
    private double a = 0.0d;
    private double b = 0.0d;
    private int c = 0;
    private com.baidu.adp.lib.c.d f = new e(this);
    private com.baidu.adp.framework.c.g g = new f(this, 103010);

    public d(g gVar) {
        this.d = null;
        this.e = null;
        this.d = new bo();
        this.e = gVar;
        this.g.b(this.c);
        com.baidu.adp.framework.c.a().a(this.g);
    }

    public final void a(int i) {
        this.c = i;
        this.d.setUniqueId(i);
    }

    public final void a() {
        com.baidu.adp.lib.c.a.a().a(true, this.f);
    }

    public final void b() {
        this.d.cancelMessage();
        com.baidu.adp.framework.c.a().b(this.g);
    }
}
