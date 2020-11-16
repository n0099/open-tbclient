package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bx;
/* loaded from: classes.dex */
public class l {
    private static String iHJ;
    public static l iHI = null;
    private static bx akt = null;

    public static synchronized void an(bx bxVar) {
        synchronized (l.class) {
            iHJ = bxVar.tid;
            akt = bxVar;
        }
    }

    public static bx cxC() {
        return akt;
    }

    public static String cxD() {
        return iHJ;
    }
}
