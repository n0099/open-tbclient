package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b jan = null;
    private e jao;

    private b() {
        this.jao = null;
        this.jao = new e(1000, 1000, 1000);
    }

    public static b csP() {
        if (jan == null) {
            synchronized (b.class) {
                if (jan == null) {
                    jan = new b();
                }
            }
        }
        return jan;
    }

    public e kc() {
        return this.jao;
    }
}
