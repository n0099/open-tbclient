package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class i {
    private static volatile h cRp;

    public static synchronized h ayc() {
        h hVar;
        synchronized (i.class) {
            if (cRp == null) {
                cRp = new h();
            }
            hVar = cRp;
        }
        return hVar;
    }
}
