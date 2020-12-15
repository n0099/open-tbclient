package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kBS = null;
    private e kBT;

    private b() {
        this.kBT = null;
        this.kBT = new e(1000, 1000, 1000);
    }

    public static b cZy() {
        if (kBS == null) {
            synchronized (b.class) {
                if (kBS == null) {
                    kBS = new b();
                }
            }
        }
        return kBS;
    }

    public e lG() {
        return this.kBT;
    }
}
