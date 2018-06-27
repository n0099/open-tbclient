package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b ewJ = null;
    private e ewK;

    private b() {
        this.ewK = null;
        this.ewK = new e(1000, 1000, 1000);
    }

    public static b aLT() {
        if (ewJ == null) {
            synchronized (b.class) {
                if (ewJ == null) {
                    ewJ = new b();
                }
            }
        }
        return ewJ;
    }

    public e fS() {
        return this.ewK;
    }
}
