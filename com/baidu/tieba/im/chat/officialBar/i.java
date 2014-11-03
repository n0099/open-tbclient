package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class i {
    public static i aRk = new i();
    private com.baidu.adp.lib.e.b<f> aQX;
    private com.baidu.adp.lib.e.b<c> aQY;
    private com.baidu.adp.lib.e.b<ba> aQZ;
    private final int aRh = 9;
    private final int aRi = 1;
    private final int aRj = 1;

    public static i Kq() {
        return aRk;
    }

    private i() {
    }

    private void W(Context context) {
        this.aQX = new k(this, new j(this, context), 1, 0);
    }

    private void X(Context context) {
        this.aQY = new m(this, new l(this, context), 9, 0);
    }

    private void Y(Context context) {
        this.aQZ = new com.baidu.adp.lib.e.b<>(new n(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<f> Z(Context context) {
        if (this.aQX == null) {
            W(context);
        }
        return this.aQX;
    }

    public com.baidu.adp.lib.e.b<c> aa(Context context) {
        if (this.aQY == null) {
            X(context);
        }
        return this.aQY;
    }

    public com.baidu.adp.lib.e.b<ba> ab(Context context) {
        if (this.aQZ == null) {
            Y(context);
        }
        return this.aQZ;
    }
}
