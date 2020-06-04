package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eTw;

    public static synchronized a boM() {
        a aVar;
        synchronized (b.class) {
            if (eTw == null) {
                eTw = new a();
            }
            aVar = eTw;
        }
        return aVar;
    }
}
