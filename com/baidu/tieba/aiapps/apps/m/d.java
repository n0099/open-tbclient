package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes4.dex */
public class d {
    private static volatile c ebL;

    public static synchronized c aYu() {
        c cVar;
        synchronized (d.class) {
            if (ebL == null) {
                ebL = new c();
            }
            cVar = ebL;
        }
        return cVar;
    }
}
