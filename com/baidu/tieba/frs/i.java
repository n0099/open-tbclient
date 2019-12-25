package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String giI;
    public static i giH = null;
    private static bj Nl = null;

    public static synchronized void ah(bj bjVar) {
        synchronized (i.class) {
            giI = bjVar.tid;
            Nl = bjVar;
        }
    }

    public static bj bAW() {
        return Nl;
    }

    public static String bAX() {
        return giI;
    }
}
