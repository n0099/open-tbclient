package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class l {
    private static String iAY;
    public static l iAX = null;
    private static bw akq = null;

    public static synchronized void al(bw bwVar) {
        synchronized (l.class) {
            iAY = bwVar.tid;
            akq = bwVar;
        }
    }

    public static bw cvy() {
        return akq;
    }

    public static String cvz() {
        return iAY;
    }
}
