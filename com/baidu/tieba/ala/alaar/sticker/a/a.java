package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes11.dex */
public class a {
    private static a gtr;

    public static a bPU() {
        if (gtr == null) {
            gtr = bPV();
        }
        return gtr;
    }

    private static synchronized a bPV() {
        a aVar;
        synchronized (a.class) {
            if (gtr == null) {
                gtr = new a();
            }
            aVar = gtr;
        }
        return aVar;
    }

    private a() {
    }

    public File bPW() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bPX() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
