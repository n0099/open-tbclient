package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class l {
    private static String iGV;
    public static l iGU = null;
    private static bw akq = null;

    public static synchronized void al(bw bwVar) {
        synchronized (l.class) {
            iGV = bwVar.tid;
            akq = bwVar;
        }
    }

    public static bw cxZ() {
        return akq;
    }

    public static String cya() {
        return iGV;
    }
}
