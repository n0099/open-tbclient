package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class l {
    private static String hZB;
    public static l hZA = null;
    private static bw ajX = null;

    public static synchronized void al(bw bwVar) {
        synchronized (l.class) {
            hZB = bwVar.tid;
            ajX = bwVar;
        }
    }

    public static bw coT() {
        return ajX;
    }

    public static String coU() {
        return hZB;
    }
}
