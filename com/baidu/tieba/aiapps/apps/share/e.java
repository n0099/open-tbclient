package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d egh;

    public static synchronized d bbj() {
        d dVar;
        synchronized (e.class) {
            if (egh == null) {
                egh = new d();
            }
            dVar = egh;
        }
        return dVar;
    }
}
