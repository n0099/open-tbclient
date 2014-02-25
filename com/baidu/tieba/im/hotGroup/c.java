package com.baidu.tieba.im.hotGroup;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.aq;
import com.baidu.tieba.im.messageCenter.e;
/* loaded from: classes.dex */
public class c {
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final int h = 30;
    private int b = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
    private int a = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
    private int c = 30;

    public void a(int i) {
        this.d = i;
    }

    public boolean a() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.f;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.g;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public void d(boolean z) {
        if (!c()) {
            c(true);
            if (z) {
                aq aqVar = new aq(this.b, this.a, this.c, this.d);
                aqVar.e(-116);
                e.a().a(aqVar);
                return;
            }
            e.a().a(new aq(this.b, this.a, this.c, this.d));
        }
    }
}
