package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes5.dex */
public class e {
    private static volatile d ecd;

    public static synchronized d aYS() {
        d dVar;
        synchronized (e.class) {
            if (ecd == null) {
                ecd = new d();
            }
            dVar = ecd;
        }
        return dVar;
    }
}
