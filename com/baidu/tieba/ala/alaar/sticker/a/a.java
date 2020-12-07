package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a gkz;

    public static a bQA() {
        if (gkz == null) {
            gkz = bQB();
        }
        return gkz;
    }

    private static synchronized a bQB() {
        a aVar;
        synchronized (a.class) {
            if (gkz == null) {
                gkz = new a();
            }
            aVar = gkz;
        }
        return aVar;
    }

    private a() {
    }

    public File bQC() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bQD() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
