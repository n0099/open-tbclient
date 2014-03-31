package com.baidu.tieba.im.hotGroup;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.am;
import com.baidu.tieba.im.message.an;
/* loaded from: classes.dex */
public final class d {
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final int h = 30;
    private int b = i.a(TbadkApplication.j().c(), 70.0f);
    private int a = i.a(TbadkApplication.j().c(), 70.0f);
    private int c = 30;

    public final void a(int i) {
        this.d = i;
    }

    public final boolean a() {
        return this.e;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final boolean b() {
        return this.f;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final void c(boolean z) {
        this.g = z;
    }

    public final void d(boolean z) {
        if (!this.g) {
            this.g = true;
            if (z) {
                com.baidu.adp.framework.c.a().a(new am(this.b, this.a, this.c, this.d));
                return;
            }
            com.baidu.adp.framework.c.a().a(new an(this.b, this.a, this.c, this.d));
        }
    }
}
