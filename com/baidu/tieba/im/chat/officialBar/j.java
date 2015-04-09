package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes.dex */
public class j {
    public static j aYY = new j();
    private com.baidu.adp.lib.e.b<g> aYH;
    private com.baidu.adp.lib.e.b<d> aYI;
    private com.baidu.adp.lib.e.b<av> aYJ;
    private final int aYV = 9;
    private final int aYW = 1;
    private final int aYX = 1;

    public static j Oi() {
        return aYY;
    }

    private j() {
    }

    private void ao(Context context) {
        this.aYH = new l(this, new k(this, context), 1, 0);
    }

    private void ap(Context context) {
        this.aYI = new n(this, new m(this, context), 9, 0);
    }

    private void aq(Context context) {
        this.aYJ = new com.baidu.adp.lib.e.b<>(new o(this, context), 1, 0);
    }

    public com.baidu.adp.lib.e.b<g> ar(Context context) {
        if (this.aYH == null) {
            ao(context);
        }
        return this.aYH;
    }

    public com.baidu.adp.lib.e.b<d> as(Context context) {
        if (this.aYI == null) {
            ap(context);
        }
        return this.aYI;
    }

    public com.baidu.adp.lib.e.b<av> at(Context context) {
        if (this.aYJ == null) {
            aq(context);
        }
        return this.aYJ;
    }
}
