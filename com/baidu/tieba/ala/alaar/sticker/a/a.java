package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static a eKv;

    public static a bko() {
        if (eKv == null) {
            eKv = bkp();
        }
        return eKv;
    }

    private static synchronized a bkp() {
        a aVar;
        synchronized (a.class) {
            if (eKv == null) {
                eKv = new a();
            }
            aVar = eKv;
        }
        return aVar;
    }

    private a() {
    }

    public File bkq() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bkr() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
