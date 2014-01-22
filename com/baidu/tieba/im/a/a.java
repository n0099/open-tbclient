package com.baidu.tieba.im.a;

import com.baidu.tieba.im.message.y;
import com.baidu.tieba.im.messageCenter.e;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    public static boolean a = true;
    private int d;
    private int e;
    private String f;
    private String g;
    private d h;
    private boolean c = false;
    private g i = new b(this);
    com.baidu.adp.lib.c.d b = new c(this);

    public void a(d dVar) {
        this.h = dVar;
    }

    public void a() {
        if (this.c) {
            if (UtilHelper.b()) {
                com.baidu.adp.lib.c.a.a().a(true, this.b);
                return;
            } else if (this.h != null) {
                this.h.G();
                return;
            } else {
                return;
            }
        }
        this.c = true;
        e.a().a(new y());
    }

    public void b() {
        a();
    }

    public void c() {
        e.a().a(103011, this.i);
        e.a().a(-114, this.i);
    }

    public void d() {
        e.a().a(this.i);
    }
}
