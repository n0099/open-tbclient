package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c efY;

    public static synchronized c bbf() {
        c cVar;
        synchronized (d.class) {
            if (efY == null) {
                efY = new c();
            }
            cVar = efY;
        }
        return cVar;
    }
}
