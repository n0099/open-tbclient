package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class l {
    private static String preloadId;
    public static l jah = null;
    private static bz ale = null;

    public static synchronized void an(bz bzVar) {
        synchronized (l.class) {
            preloadId = bzVar.tid;
            ale = bzVar;
        }
    }

    public static bz cAW() {
        return ale;
    }

    public static String cAX() {
        return preloadId;
    }
}
