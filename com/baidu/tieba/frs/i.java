package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String gnU;
    public static i gnT = null;
    private static bj NQ = null;

    public static synchronized void aj(bj bjVar) {
        synchronized (i.class) {
            gnU = bjVar.tid;
            NQ = bjVar;
        }
    }

    public static bj bDD() {
        return NQ;
    }

    public static String bDE() {
        return gnU;
    }
}
