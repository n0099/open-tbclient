package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public final class m {
    public static m a = new m();
    private final int b = 9;
    private final int c = 1;
    private final int d = 1;
    private com.baidu.adp.lib.d.b<h> e;
    private com.baidu.adp.lib.d.b<c> f;
    private com.baidu.adp.lib.d.b<bg> g;

    public static m a() {
        return a;
    }

    private m() {
    }

    public final com.baidu.adp.lib.d.b<h> a(Context context) {
        if (this.e == null) {
            this.e = new o(this, new n(this, context), 1, 0);
        }
        return this.e;
    }

    public final com.baidu.adp.lib.d.b<c> b(Context context) {
        if (this.f == null) {
            this.f = new q(this, new p(this, context), 9, 0);
        }
        return this.f;
    }

    public final com.baidu.adp.lib.d.b<bg> c(Context context) {
        if (this.g == null) {
            this.g = new com.baidu.adp.lib.d.b<>(new r(this, context), 1, 0);
        }
        return this.g;
    }
}
