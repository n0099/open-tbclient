package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes5.dex */
public class e {
    private static volatile d dZY;

    public static synchronized d aXF() {
        d dVar;
        synchronized (e.class) {
            if (dZY == null) {
                dZY = new d();
            }
            dVar = dZY;
        }
        return dVar;
    }
}
