package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes5.dex */
public class d {
    private static volatile c ebU;

    public static synchronized c aYO() {
        c cVar;
        synchronized (d.class) {
            if (ebU == null) {
                ebU = new c();
            }
            cVar = ebU;
        }
        return cVar;
    }
}
