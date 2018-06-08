package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b esS = null;
    private e esT;

    private b() {
        this.esT = null;
        this.esT = new e(1000, 1000, 1000);
    }

    public static b aLn() {
        if (esS == null) {
            synchronized (b.class) {
                if (esS == null) {
                    esS = new b();
                }
            }
        }
        return esS;
    }

    public e fS() {
        return this.esT;
    }
}
