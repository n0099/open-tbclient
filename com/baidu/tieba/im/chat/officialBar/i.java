package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class i {
    public static i aUc = new i();
    private com.baidu.adp.lib.e.b<f> aTL;
    private com.baidu.adp.lib.e.b<c> aTM;
    private com.baidu.adp.lib.e.b<ar> aTN;
    private final int aTZ = 9;
    private final int aUa = 1;
    private final int aUb = 1;

    public static i KU() {
        return aUc;
    }

    private i() {
    }

    private void ak(Context context) {
        this.aTL = new k(this, new j(this, context), 1, 0);
    }

    private void al(Context context) {
        this.aTM = new m(this, new l(this, context), 9, 0);
    }

    private void am(Context context) {
        this.aTN = new com.baidu.adp.lib.e.b<>(new n(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<f> an(Context context) {
        if (this.aTL == null) {
            ak(context);
        }
        return this.aTL;
    }

    public com.baidu.adp.lib.e.b<c> ao(Context context) {
        if (this.aTM == null) {
            al(context);
        }
        return this.aTM;
    }

    public com.baidu.adp.lib.e.b<ar> ap(Context context) {
        if (this.aTN == null) {
            am(context);
        }
        return this.aTN;
    }
}
