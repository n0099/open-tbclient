package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes10.dex */
public class a {
    private static a gva;

    public static a bQa() {
        if (gva == null) {
            gva = bQb();
        }
        return gva;
    }

    private static synchronized a bQb() {
        a aVar;
        synchronized (a.class) {
            if (gva == null) {
                gva = new a();
            }
            aVar = gva;
        }
        return aVar;
    }

    private a() {
    }

    public File bQc() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bQd() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
