package com.baidu.tieba.im.a;

import com.baidu.tieba.im.message.ab;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public final class a {
    public static boolean a = true;
    private int d;
    private int e;
    private String f;
    private String g;
    private d h;
    private boolean c = false;
    private g i = new b(this);
    com.baidu.adp.lib.c.d b = new c(this);

    public final void a(d dVar) {
        this.h = dVar;
    }

    public final void a() {
        if (this.c) {
            if (UtilHelper.b()) {
                com.baidu.adp.lib.c.a.a().a(true, this.b);
                return;
            } else if (this.h != null) {
                this.h.a();
                return;
            } else {
                return;
            }
        }
        this.c = true;
        com.baidu.tieba.im.messageCenter.d.a().a(new ab());
    }

    public final void b() {
        a();
    }

    public final void c() {
        com.baidu.tieba.im.messageCenter.d.a().a(103011, this.i);
        com.baidu.tieba.im.messageCenter.d.a().a(-114, this.i);
    }

    public final void d() {
        com.baidu.tieba.im.messageCenter.d.a().a(this.i);
    }
}
