package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b jiJ = null;
    private e jiK;

    private b() {
        this.jiK = null;
        this.jiK = new e(1000, 1000, 1000);
    }

    public static b cwR() {
        if (jiJ == null) {
            synchronized (b.class) {
                if (jiJ == null) {
                    jiJ = new b();
                }
            }
        }
        return jiJ;
    }

    public e kc() {
        return this.jiK;
    }
}
