package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eLD = null;
    private e eLE;

    private b() {
        this.eLE = null;
        this.eLE = new e(1000, 1000, 1000);
    }

    public static b aLw() {
        if (eLD == null) {
            synchronized (b.class) {
                if (eLD == null) {
                    eLD = new b();
                }
            }
        }
        return eLD;
    }

    public e kZ() {
        return this.eLE;
    }
}
