package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes2.dex */
public class c {
    private static volatile b deJ;

    public static synchronized b aFL() {
        b bVar;
        synchronized (c.class) {
            if (deJ == null) {
                deJ = new b();
            }
            bVar = deJ;
        }
        return bVar;
    }
}
