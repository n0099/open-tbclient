package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWD;

    public static synchronized c azR() {
        c cVar;
        synchronized (d.class) {
            if (cWD == null) {
                cWD = new c();
            }
            cVar = cWD;
        }
        return cVar;
    }
}
