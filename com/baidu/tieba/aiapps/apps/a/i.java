package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class i {
    private static volatile h cRs;

    public static synchronized h axZ() {
        h hVar;
        synchronized (i.class) {
            if (cRs == null) {
                cRs = new h();
            }
            hVar = cRs;
        }
        return hVar;
    }
}
