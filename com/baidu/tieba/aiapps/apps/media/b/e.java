package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eEw;

    public static synchronized d bif() {
        d dVar;
        synchronized (e.class) {
            if (eEw == null) {
                eEw = new d();
            }
            dVar = eEw;
        }
        return dVar;
    }
}
