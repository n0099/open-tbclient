package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes4.dex */
public class b {
    private static volatile a ebw;

    public static synchronized a aXY() {
        a aVar;
        synchronized (b.class) {
            if (ebw == null) {
                ebw = new a();
            }
            aVar = ebw;
        }
        return aVar;
    }
}
