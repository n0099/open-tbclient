package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class l {
    private static String preloadId;
    public static l jhK = null;
    private static cb amn = null;

    public static synchronized void ao(cb cbVar) {
        synchronized (l.class) {
            preloadId = cbVar.tid;
            amn = cbVar;
        }
    }

    public static cb cCv() {
        return amn;
    }

    public static String cCw() {
        return preloadId;
    }
}
