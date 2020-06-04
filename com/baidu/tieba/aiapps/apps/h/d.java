package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eTl;

    public static synchronized c boE() {
        c cVar;
        synchronized (d.class) {
            if (eTl == null) {
                eTl = new c();
            }
            cVar = eTl;
        }
        return cVar;
    }
}
