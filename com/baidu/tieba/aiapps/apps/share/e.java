package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dhR;

    public static synchronized d aHD() {
        d dVar;
        synchronized (e.class) {
            if (dhR == null) {
                dhR = new d();
            }
            dVar = dhR;
        }
        return dVar;
    }
}
