package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class l {
    private static String preloadId;
    public static l jeO = null;
    private static bz alW = null;

    public static synchronized void an(bz bzVar) {
        synchronized (l.class) {
            preloadId = bzVar.tid;
            alW = bzVar;
        }
    }

    public static bz cEN() {
        return alW;
    }

    public static String cEO() {
        return preloadId;
    }
}
