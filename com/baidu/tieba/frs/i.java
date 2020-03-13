package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String goh;
    public static i gog = null;
    private static bj NQ = null;

    public static synchronized void aj(bj bjVar) {
        synchronized (i.class) {
            goh = bjVar.tid;
            NQ = bjVar;
        }
    }

    public static bj bDE() {
        return NQ;
    }

    public static String bDF() {
        return goh;
    }
}
