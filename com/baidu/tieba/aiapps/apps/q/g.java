package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dhS;

    public static synchronized f aHL() {
        f fVar;
        synchronized (g.class) {
            if (dhS == null) {
                dhS = new f();
            }
            fVar = dhS;
        }
        return fVar;
    }
}
