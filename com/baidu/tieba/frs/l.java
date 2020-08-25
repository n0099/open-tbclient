package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bw;
/* loaded from: classes2.dex */
public class l {
    private static String hSv;
    public static l hSu = null;
    private static bw ajx = null;

    public static synchronized void ak(bw bwVar) {
        synchronized (l.class) {
            hSv = bwVar.tid;
            ajx = bwVar;
        }
    }

    public static bw clG() {
        return ajx;
    }

    public static String clH() {
        return hSv;
    }
}
