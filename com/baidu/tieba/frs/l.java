package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class l {
    private static String preloadId;
    public static l jfN = null;
    private static cb akU = null;

    public static synchronized void ao(cb cbVar) {
        synchronized (l.class) {
            preloadId = cbVar.tid;
            akU = cbVar;
        }
    }

    public static cb cCi() {
        return akU;
    }

    public static String cCj() {
        return preloadId;
    }
}
