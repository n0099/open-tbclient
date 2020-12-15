package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.by;
/* loaded from: classes.dex */
public class l {
    private static String iSD;
    public static l iSC = null;
    private static by alu = null;

    public static synchronized void an(by byVar) {
        synchronized (l.class) {
            iSD = byVar.tid;
            alu = byVar;
        }
    }

    public static by cBT() {
        return alu;
    }

    public static String cBU() {
        return iSD;
    }
}
