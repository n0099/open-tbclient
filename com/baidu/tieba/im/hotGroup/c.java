package com.baidu.tieba.im.hotGroup;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.aq;
/* loaded from: classes.dex */
public final class c {
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final int h = 30;
    private int b = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
    private int a = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
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
                aq aqVar = new aq(this.b, this.a, this.c, this.d);
                aqVar.e(-116);
                com.baidu.tieba.im.messageCenter.d.a().a(aqVar);
                return;
            }
            com.baidu.tieba.im.messageCenter.d.a().a(new aq(this.b, this.a, this.c, this.d));
        }
    }
}
