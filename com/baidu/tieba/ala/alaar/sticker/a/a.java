package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a gkB;

    public static a bQB() {
        if (gkB == null) {
            gkB = bQC();
        }
        return gkB;
    }

    private static synchronized a bQC() {
        a aVar;
        synchronized (a.class) {
            if (gkB == null) {
                gkB = new a();
            }
            aVar = gkB;
        }
        return aVar;
    }

    private a() {
    }

    public File bQD() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bQE() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
