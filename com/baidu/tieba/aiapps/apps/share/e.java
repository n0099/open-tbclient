package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d egu;

    public static synchronized d bbk() {
        d dVar;
        synchronized (e.class) {
            if (egu == null) {
                egu = new d();
            }
            dVar = egu;
        }
        return dVar;
    }
}
