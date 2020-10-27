package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b khN = null;
    private e khO;

    private b() {
        this.khO = null;
        this.khO = new e(1000, 1000, 1000);
    }

    public static b cSe() {
        if (khN == null) {
            synchronized (b.class) {
                if (khN == null) {
                    khN = new b();
                }
            }
        }
        return khN;
    }

    public e lG() {
        return this.khO;
    }
}
