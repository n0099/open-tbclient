package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.by;
/* loaded from: classes.dex */
public class l {
    private static String iSB;
    public static l iSA = null;
    private static by alu = null;

    public static synchronized void an(by byVar) {
        synchronized (l.class) {
            iSB = byVar.tid;
            alu = byVar;
        }
    }

    public static by cBS() {
        return alu;
    }

    public static String cBT() {
        return iSB;
    }
}
