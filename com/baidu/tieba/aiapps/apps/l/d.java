package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eTt;

    public static synchronized c boO() {
        c cVar;
        synchronized (d.class) {
            if (eTt == null) {
                eTt = new c();
            }
            cVar = eTt;
        }
        return cVar;
    }
}
