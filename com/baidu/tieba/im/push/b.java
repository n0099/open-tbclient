package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eHA = null;
    private e eHB;

    private b() {
        this.eHB = null;
        this.eHB = new e(1000, 1000, 1000);
    }

    public static b aJV() {
        if (eHA == null) {
            synchronized (b.class) {
                if (eHA == null) {
                    eHA = new b();
                }
            }
        }
        return eHA;
    }

    public e kZ() {
        return this.eHB;
    }
}
