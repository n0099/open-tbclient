package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String gXW;
    public static i gXV = null;
    private static bj agz = null;

    public static synchronized void am(bj bjVar) {
        synchronized (i.class) {
            gXW = bjVar.tid;
            agz = bjVar;
        }
    }

    public static bj bOl() {
        return agz;
    }

    public static String bOm() {
        return gXW;
    }
}
