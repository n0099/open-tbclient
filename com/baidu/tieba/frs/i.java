package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String gnS;
    public static i gnR = null;
    private static bj NQ = null;

    public static synchronized void aj(bj bjVar) {
        synchronized (i.class) {
            gnS = bjVar.tid;
            NQ = bjVar;
        }
    }

    public static bj bDB() {
        return NQ;
    }

    public static String bDC() {
        return gnS;
    }
}
