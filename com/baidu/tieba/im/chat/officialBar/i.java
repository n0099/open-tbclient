package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class i {
    public static i aQW = new i();
    private com.baidu.adp.lib.e.b<f> aQJ;
    private com.baidu.adp.lib.e.b<c> aQK;
    private com.baidu.adp.lib.e.b<ba> aQL;
    private final int aQT = 9;
    private final int aQU = 1;
    private final int aQV = 1;

    public static i Km() {
        return aQW;
    }

    private i() {
    }

    private void W(Context context) {
        this.aQJ = new k(this, new j(this, context), 1, 0);
    }

    private void X(Context context) {
        this.aQK = new m(this, new l(this, context), 9, 0);
    }

    private void Y(Context context) {
        this.aQL = new com.baidu.adp.lib.e.b<>(new n(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<f> Z(Context context) {
        if (this.aQJ == null) {
            W(context);
        }
        return this.aQJ;
    }

    public com.baidu.adp.lib.e.b<c> aa(Context context) {
        if (this.aQK == null) {
            X(context);
        }
        return this.aQK;
    }

    public com.baidu.adp.lib.e.b<ba> ab(Context context) {
        if (this.aQL == null) {
            Y(context);
        }
        return this.aQL;
    }
}
