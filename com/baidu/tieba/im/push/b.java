package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b iJk = null;
    private e iJl;

    private b() {
        this.iJl = null;
        this.iJl = new e(1000, 1000, 1000);
    }

    public static b coZ() {
        if (iJk == null) {
            synchronized (b.class) {
                if (iJk == null) {
                    iJk = new b();
                }
            }
        }
        return iJk;
    }

    public e jM() {
        return this.iJl;
    }
}
