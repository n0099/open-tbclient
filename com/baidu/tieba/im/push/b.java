package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b iIx = null;
    private e iIy;

    private b() {
        this.iIy = null;
        this.iIy = new e(1000, 1000, 1000);
    }

    public static b coQ() {
        if (iIx == null) {
            synchronized (b.class) {
                if (iIx == null) {
                    iIx = new b();
                }
            }
        }
        return iIx;
    }

    public e jM() {
        return this.iIy;
    }
}
