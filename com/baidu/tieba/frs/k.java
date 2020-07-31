package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bv;
/* loaded from: classes.dex */
public class k {
    private static String hFf;
    public static k hFe = null;
    private static bv aii = null;

    public static synchronized void ak(bv bvVar) {
        synchronized (k.class) {
            hFf = bvVar.tid;
            aii = bvVar;
        }
    }

    public static bv cbk() {
        return aii;
    }

    public static String cbl() {
        return hFf;
    }
}
