package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a gcH;

    public static a bNw() {
        if (gcH == null) {
            gcH = bNx();
        }
        return gcH;
    }

    private static synchronized a bNx() {
        a aVar;
        synchronized (a.class) {
            if (gcH == null) {
                gcH = new a();
            }
            aVar = gcH;
        }
        return aVar;
    }

    private a() {
    }

    public File bNy() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bNz() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
