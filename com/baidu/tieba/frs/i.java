package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class i {
    private static String hmO;
    public static i hmN = null;
    private static bk ahg = null;

    public static synchronized void an(bk bkVar) {
        synchronized (i.class) {
            hmO = bkVar.tid;
            ahg = bkVar;
        }
    }

    public static bk bUF() {
        return ahg;
    }

    public static String bUG() {
        return hmO;
    }
}
