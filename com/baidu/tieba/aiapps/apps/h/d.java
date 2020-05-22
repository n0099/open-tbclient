package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eTa;

    public static synchronized c boC() {
        c cVar;
        synchronized (d.class) {
            if (eTa == null) {
                eTa = new c();
            }
            cVar = eTa;
        }
        return cVar;
    }
}
