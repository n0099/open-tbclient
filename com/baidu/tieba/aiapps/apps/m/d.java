package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c gnc;

    public static synchronized c bNV() {
        c cVar;
        synchronized (d.class) {
            if (gnc == null) {
                gnc = new c();
            }
            cVar = gnc;
        }
        return cVar;
    }
}
