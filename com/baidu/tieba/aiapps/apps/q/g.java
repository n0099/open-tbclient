package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dhZ;

    public static synchronized f aHN() {
        f fVar;
        synchronized (g.class) {
            if (dhZ == null) {
                dhZ = new f();
            }
            fVar = dhZ;
        }
        return fVar;
    }
}
