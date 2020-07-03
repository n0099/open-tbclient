package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static a fhD;

    public static a bsr() {
        if (fhD == null) {
            fhD = bss();
        }
        return fhD;
    }

    private static synchronized a bss() {
        a aVar;
        synchronized (a.class) {
            if (fhD == null) {
                fhD = new a();
            }
            aVar = fhD;
        }
        return aVar;
    }

    private a() {
    }

    public File bst() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bsu() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
