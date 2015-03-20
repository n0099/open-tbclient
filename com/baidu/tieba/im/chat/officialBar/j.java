package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class j {
    public static j aYI = new j();
    private final int aYF = 9;
    private final int aYG = 1;
    private final int aYH = 1;
    private com.baidu.adp.lib.e.b<g> aYr;
    private com.baidu.adp.lib.e.b<d> aYs;
    private com.baidu.adp.lib.e.b<av> aYt;

    public static j NV() {
        return aYI;
    }

    private j() {
    }

    private void ao(Context context) {
        this.aYr = new l(this, new k(this, context), 1, 0);
    }

    private void ap(Context context) {
        this.aYs = new n(this, new m(this, context), 9, 0);
    }

    private void aq(Context context) {
        this.aYt = new com.baidu.adp.lib.e.b<>(new o(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<g> ar(Context context) {
        if (this.aYr == null) {
            ao(context);
        }
        return this.aYr;
    }

    public com.baidu.adp.lib.e.b<d> as(Context context) {
        if (this.aYs == null) {
            ap(context);
        }
        return this.aYs;
    }

    public com.baidu.adp.lib.e.b<av> at(Context context) {
        if (this.aYt == null) {
            aq(context);
        }
        return this.aYt;
    }
}
