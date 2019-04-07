package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class i {
    private static volatile h cRr;

    public static synchronized h axZ() {
        h hVar;
        synchronized (i.class) {
            if (cRr == null) {
                cRr = new h();
            }
            hVar = cRr;
        }
        return hVar;
    }
}
