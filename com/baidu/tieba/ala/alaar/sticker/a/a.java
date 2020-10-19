package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a fNG;

    public static a bIz() {
        if (fNG == null) {
            fNG = bIA();
        }
        return fNG;
    }

    private static synchronized a bIA() {
        a aVar;
        synchronized (a.class) {
            if (fNG == null) {
                fNG = new a();
            }
            aVar = fNG;
        }
        return aVar;
    }

    private a() {
    }

    public File bIB() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bIC() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
