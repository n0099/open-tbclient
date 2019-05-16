package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dbL;

    public static synchronized f aEt() {
        f fVar;
        synchronized (g.class) {
            if (dbL == null) {
                dbL = new f();
            }
            fVar = dbL;
        }
        return fVar;
    }
}
