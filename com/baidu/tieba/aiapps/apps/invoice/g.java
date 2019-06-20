package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dbN;

    public static synchronized f aEw() {
        f fVar;
        synchronized (g.class) {
            if (dbN == null) {
                dbN = new f();
            }
            fVar = dbN;
        }
        return fVar;
    }
}
