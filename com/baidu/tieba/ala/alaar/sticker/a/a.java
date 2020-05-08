package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static a eKA;

    public static a bkm() {
        if (eKA == null) {
            eKA = bkn();
        }
        return eKA;
    }

    private static synchronized a bkn() {
        a aVar;
        synchronized (a.class) {
            if (eKA == null) {
                eKA = new a();
            }
            aVar = eKA;
        }
        return aVar;
    }

    private a() {
    }

    public File bko() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bkp() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
