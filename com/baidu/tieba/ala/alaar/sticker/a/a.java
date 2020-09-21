package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a fBx;

    public static a bFN() {
        if (fBx == null) {
            fBx = bFO();
        }
        return fBx;
    }

    private static synchronized a bFO() {
        a aVar;
        synchronized (a.class) {
            if (fBx == null) {
                fBx = new a();
            }
            aVar = fBx;
        }
        return aVar;
    }

    private a() {
    }

    public File bFP() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bFQ() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
