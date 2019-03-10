package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class i {
    private static volatile h cRt;

    public static synchronized h ayd() {
        h hVar;
        synchronized (i.class) {
            if (cRt == null) {
                cRt = new h();
            }
            hVar = cRt;
        }
        return hVar;
    }
}
