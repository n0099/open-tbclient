package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a fmM;

    public static a bvB() {
        if (fmM == null) {
            fmM = bvC();
        }
        return fmM;
    }

    private static synchronized a bvC() {
        a aVar;
        synchronized (a.class) {
            if (fmM == null) {
                fmM = new a();
            }
            aVar = fmM;
        }
        return aVar;
    }

    private a() {
    }

    public File bvD() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bvE() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
