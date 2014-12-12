package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class i {
    public static i aSQ = new i();
    private com.baidu.adp.lib.e.b<f> aSB;
    private com.baidu.adp.lib.e.b<c> aSC;
    private com.baidu.adp.lib.e.b<ar> aSD;
    private final int aSN = 9;
    private final int aSO = 1;
    private final int aSP = 1;

    public static i Kz() {
        return aSQ;
    }

    private i() {
    }

    private void ak(Context context) {
        this.aSB = new k(this, new j(this, context), 1, 0);
    }

    private void al(Context context) {
        this.aSC = new m(this, new l(this, context), 9, 0);
    }

    private void am(Context context) {
        this.aSD = new com.baidu.adp.lib.e.b<>(new n(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<f> an(Context context) {
        if (this.aSB == null) {
            ak(context);
        }
        return this.aSB;
    }

    public com.baidu.adp.lib.e.b<c> ao(Context context) {
        if (this.aSC == null) {
            al(context);
        }
        return this.aSC;
    }

    public com.baidu.adp.lib.e.b<ar> ap(Context context) {
        if (this.aSD == null) {
            am(context);
        }
        return this.aSD;
    }
}
