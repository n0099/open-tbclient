package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b ehC = null;
    private e ehD;

    private b() {
        this.ehD = null;
        this.ehD = new e(1000, 1000, 1000);
    }

    public static b aGs() {
        if (ehC == null) {
            synchronized (b.class) {
                if (ehC == null) {
                    ehC = new b();
                }
            }
        }
        return ehC;
    }

    public e dd() {
        return this.ehD;
    }
}
