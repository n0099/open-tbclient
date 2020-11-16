package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kou = null;
    private e kov;

    private b() {
        this.kov = null;
        this.kov = new e(1000, 1000, 1000);
    }

    public static b cUl() {
        if (kou == null) {
            synchronized (b.class) {
                if (kou == null) {
                    kou = new b();
                }
            }
        }
        return kou;
    }

    public e lG() {
        return this.kov;
    }
}
