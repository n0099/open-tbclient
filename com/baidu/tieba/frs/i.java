package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String goR;
    public static i goQ = null;
    private static bj NR = null;

    public static synchronized void ak(bj bjVar) {
        synchronized (i.class) {
            goR = bjVar.tid;
            NR = bjVar;
        }
    }

    public static bj bDM() {
        return NR;
    }

    public static String bDN() {
        return goR;
    }
}
