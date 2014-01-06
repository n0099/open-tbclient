package com.baidu.tieba.im.a;

import com.baidu.tieba.im.message.w;
import com.baidu.tieba.im.messageCenter.e;
import com.baidu.tieba.im.messageCenter.g;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    public static boolean a = true;
    private int d;
    private int e;
    private d f;
    private boolean c = false;
    private g g = new b(this);
    com.baidu.adp.lib.c.d b = new c(this);

    public void a(d dVar) {
        this.f = dVar;
    }

    public void a() {
        if (this.c) {
            if (UtilHelper.b()) {
                com.baidu.adp.lib.c.a.a().a(true, this.b);
                return;
            } else if (this.f != null) {
                this.f.G();
                return;
            } else {
                return;
            }
        }
        this.c = true;
        e.a().a(new w());
    }

    public void b() {
        a();
    }

    public void c() {
        e.a().a(103011, this.g);
        e.a().a(-114, this.g);
    }

    public void d() {
        e.a().a(this.g);
    }
}
