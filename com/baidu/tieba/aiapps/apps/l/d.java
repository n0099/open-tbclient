package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWo;

    public static synchronized c azM() {
        c cVar;
        synchronized (d.class) {
            if (cWo == null) {
                cWo = new c();
            }
            cVar = cWo;
        }
        return cVar;
    }
}
