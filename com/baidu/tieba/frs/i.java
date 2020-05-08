package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String gYc;
    public static i gYb = null;
    private static bj agC = null;

    public static synchronized void am(bj bjVar) {
        synchronized (i.class) {
            gYc = bjVar.tid;
            agC = bjVar;
        }
    }

    public static bj bOj() {
        return agC;
    }

    public static String bOk() {
        return gYc;
    }
}
