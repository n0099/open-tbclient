package com.baidu.tieba.im.hotGroup;

import android.content.Context;
import com.baidu.adp.lib.g.g;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ak;
import com.baidu.tieba.im.messageCenter.e;
/* loaded from: classes.dex */
public class c {
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final int h = 30;
    private int b = g.a((Context) TiebaApplication.a(), 70.0f);
    private int a = g.a((Context) TiebaApplication.a(), 70.0f);
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
                ak akVar = new ak(this.b, this.a, this.c, this.d);
                akVar.e(-116);
                e.a().a(akVar);
                return;
            }
            e.a().a(new ak(this.b, this.a, this.c, this.d));
        }
    }
}
