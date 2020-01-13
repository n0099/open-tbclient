package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class i {
    private static String glR;
    public static i glQ = null;
    private static bj Np = null;

    public static synchronized void ai(bj bjVar) {
        synchronized (i.class) {
            glR = bjVar.tid;
            Np = bjVar;
        }
    }

    public static bj bBY() {
        return Np;
    }

    public static String bBZ() {
        return glR;
    }
}
