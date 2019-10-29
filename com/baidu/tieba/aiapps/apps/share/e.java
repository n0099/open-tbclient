package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dsW;

    public static synchronized d aIr() {
        d dVar;
        synchronized (e.class) {
            if (dsW == null) {
                dsW = new d();
            }
            dVar = dsW;
        }
        return dVar;
    }
}
