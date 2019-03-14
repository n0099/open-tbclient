package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cSX;

    public static synchronized d aza() {
        d dVar;
        synchronized (e.class) {
            if (cSX == null) {
                cSX = new d();
            }
            dVar = cSX;
        }
        return dVar;
    }
}
