package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class l {
    private static String preloadId;
    public static l jgb = null;
    private static cb akU = null;

    public static synchronized void ao(cb cbVar) {
        synchronized (l.class) {
            preloadId = cbVar.tid;
            akU = cbVar;
        }
    }

    public static cb cCp() {
        return akU;
    }

    public static String cCq() {
        return preloadId;
    }
}
