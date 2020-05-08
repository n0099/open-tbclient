package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eGF;

    public static synchronized d bjp() {
        d dVar;
        synchronized (e.class) {
            if (eGF == null) {
                eGF = new d();
            }
            dVar = eGF;
        }
        return dVar;
    }
}
