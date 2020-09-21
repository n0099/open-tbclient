package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fwj;

    public static synchronized b bDP() {
        b bVar;
        synchronized (c.class) {
            if (fwj == null) {
                fwj = new b();
            }
            bVar = fwj;
        }
        return bVar;
    }
}
