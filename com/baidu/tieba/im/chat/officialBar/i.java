package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class i {
    public static i aUb = new i();
    private com.baidu.adp.lib.e.b<f> aTK;
    private com.baidu.adp.lib.e.b<c> aTL;
    private com.baidu.adp.lib.e.b<ar> aTM;
    private final int aTY = 9;
    private final int aTZ = 1;
    private final int aUa = 1;

    public static i KP() {
        return aUb;
    }

    private i() {
    }

    private void ak(Context context) {
        this.aTK = new k(this, new j(this, context), 1, 0);
    }

    private void al(Context context) {
        this.aTL = new m(this, new l(this, context), 9, 0);
    }

    private void am(Context context) {
        this.aTM = new com.baidu.adp.lib.e.b<>(new n(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<f> an(Context context) {
        if (this.aTK == null) {
            ak(context);
        }
        return this.aTK;
    }

    public com.baidu.adp.lib.e.b<c> ao(Context context) {
        if (this.aTL == null) {
            al(context);
        }
        return this.aTL;
    }

    public com.baidu.adp.lib.e.b<ar> ap(Context context) {
        if (this.aTM == null) {
            am(context);
        }
        return this.aTM;
    }
}
