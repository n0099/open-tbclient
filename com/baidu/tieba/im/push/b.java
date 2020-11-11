package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b knK = null;
    private e knL;

    private b() {
        this.knL = null;
        this.knL = new e(1000, 1000, 1000);
    }

    public static b cUF() {
        if (knK == null) {
            synchronized (b.class) {
                if (knK == null) {
                    knK = new b();
                }
            }
        }
        return knK;
    }

    public e lG() {
        return this.knL;
    }
}
