package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b jiH = null;
    private e jiI;

    private b() {
        this.jiI = null;
        this.jiI = new e(1000, 1000, 1000);
    }

    public static b cwR() {
        if (jiH == null) {
            synchronized (b.class) {
                if (jiH == null) {
                    jiH = new b();
                }
            }
        }
        return jiH;
    }

    public e kc() {
        return this.jiI;
    }
}
