package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dbM;

    public static synchronized f aEw() {
        f fVar;
        synchronized (g.class) {
            if (dbM == null) {
                dbM = new f();
            }
            fVar = dbM;
        }
        return fVar;
    }
}
