package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    public static m a = new m();
    private final int b = 9;
    private final int c = 1;
    private final int d = 1;
    private com.baidu.adp.lib.d.b<h> e;
    private com.baidu.adp.lib.d.b<c> f;
    private com.baidu.adp.lib.d.b<bb> g;

    public static m a() {
        return a;
    }

    private m() {
    }

    private void d(Context context) {
        this.e = new o(this, new n(this, context), 1, 0);
    }

    private void e(Context context) {
        this.f = new q(this, new p(this, context), 9, 0);
    }

    private void f(Context context) {
        this.g = new com.baidu.adp.lib.d.b<>(new r(this, context), 1, 0);
    }

    public com.baidu.adp.lib.d.b<h> a(Context context) {
        if (this.e == null) {
            d(context);
        }
        return this.e;
    }

    public com.baidu.adp.lib.d.b<c> b(Context context) {
        if (this.f == null) {
            e(context);
        }
        return this.f;
    }

    public com.baidu.adp.lib.d.b<bb> c(Context context) {
        if (this.g == null) {
            f(context);
        }
        return this.g;
    }
}
