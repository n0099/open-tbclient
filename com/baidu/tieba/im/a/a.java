package com.baidu.tieba.im.a;

import com.baidu.adp.framework.c.g;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.message.w;
/* loaded from: classes.dex */
public final class a extends com.baidu.adp.a.e {
    public static boolean a = true;
    private int d;
    private int e;
    private String f;
    private String g;
    private e h;
    private boolean c = false;
    private final g i = new b(this, 103011);
    private final com.baidu.adp.framework.c.a j = new c(this, 2001114);
    com.baidu.adp.lib.c.d b = new d(this);

    public final void a(e eVar) {
        this.h = eVar;
    }

    public final void a() {
        if (this.c) {
            if (UtilHelper.a()) {
                com.baidu.adp.lib.c.a.a().a(true, this.b);
                return;
            } else if (this.h != null) {
                e eVar = this.h;
                return;
            } else {
                return;
            }
        }
        this.c = true;
        com.baidu.adp.framework.c.a().a(new w());
    }

    public final void b() {
        a();
    }

    public final void c() {
        registerListener(this.i);
        registerListener(this.j);
    }

    public final void d() {
        com.baidu.adp.framework.c.a().b(this.i);
        com.baidu.adp.framework.c.a().b(this.j);
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
