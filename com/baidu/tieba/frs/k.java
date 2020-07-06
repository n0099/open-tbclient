package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bu;
/* loaded from: classes.dex */
public class k {
    private static String hzq;
    public static k hzp = null;
    private static bu aiq = null;

    public static synchronized void an(bu buVar) {
        synchronized (k.class) {
            hzq = buVar.tid;
            aiq = buVar;
        }
    }

    public static bu bXO() {
        return aiq;
    }

    public static String bXP() {
        return hzq;
    }
}
