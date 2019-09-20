package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d deU;

    public static synchronized d aGj() {
        d dVar;
        synchronized (e.class) {
            if (deU == null) {
                deU = new d();
            }
            dVar = deU;
        }
        return dVar;
    }
}
