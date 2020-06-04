package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class i {
    private static String hmZ;
    public static i hmY = null;
    private static bk ahg = null;

    public static synchronized void an(bk bkVar) {
        synchronized (i.class) {
            hmZ = bkVar.tid;
            ahg = bkVar;
        }
    }

    public static bk bUH() {
        return ahg;
    }

    public static String bUI() {
        return hmZ;
    }
}
