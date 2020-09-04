package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class l {
    private static String hSB;
    public static l hSA = null;
    private static bw ajz = null;

    public static synchronized void ak(bw bwVar) {
        synchronized (l.class) {
            hSB = bwVar.tid;
            ajz = bwVar;
        }
    }

    public static bw clH() {
        return ajz;
    }

    public static String clI() {
        return hSB;
    }
}
