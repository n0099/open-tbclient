package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class l {
    private static String ioC;
    public static l ioB = null;
    private static bw akp = null;

    public static synchronized void al(bw bwVar) {
        synchronized (l.class) {
            ioC = bwVar.tid;
            akp = bwVar;
        }
    }

    public static bw csr() {
        return akp;
    }

    public static String css() {
        return ioC;
    }
}
