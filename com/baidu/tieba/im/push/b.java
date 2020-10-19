package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b jVn = null;
    private e jVo;

    private b() {
        this.jVo = null;
        this.jVo = new e(1000, 1000, 1000);
    }

    public static b cOX() {
        if (jVn == null) {
            synchronized (b.class) {
                if (jVn == null) {
                    jVn = new b();
                }
            }
        }
        return jVn;
    }

    public e lG() {
        return this.jVo;
    }
}
