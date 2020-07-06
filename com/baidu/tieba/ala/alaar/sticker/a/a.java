package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static a fhD;

    public static a bss() {
        if (fhD == null) {
            fhD = bst();
        }
        return fhD;
    }

    private static synchronized a bst() {
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

    public File bsu() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bsv() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
