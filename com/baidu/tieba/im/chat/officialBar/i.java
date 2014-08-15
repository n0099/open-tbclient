package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class i {
    public static i a = new i();
    private final int b = 9;
    private final int c = 1;
    private final int d = 1;
    private com.baidu.adp.lib.d.b<f> e;
    private com.baidu.adp.lib.d.b<c> f;
    private com.baidu.adp.lib.d.b<bb> g;

    public static i a() {
        return a;
    }

    private i() {
    }

    private void d(Context context) {
        this.e = new k(this, new j(this, context), 1, 0);
    }

    private void e(Context context) {
        this.f = new m(this, new l(this, context), 9, 0);
    }

    private void f(Context context) {
        this.g = new com.baidu.adp.lib.d.b<>(new n(this, context), 1, 0);
    }

    public com.baidu.adp.lib.d.b<f> a(Context context) {
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
