package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes7.dex */
public class a {
    private static a fyl;

    public static a bEx() {
        if (fyl == null) {
            fyl = bEy();
        }
        return fyl;
    }

    private static synchronized a bEy() {
        a aVar;
        synchronized (a.class) {
            if (fyl == null) {
                fyl = new a();
            }
            aVar = fyl;
        }
        return aVar;
    }

    private a() {
    }

    public File bEz() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bEA() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
