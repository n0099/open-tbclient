package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes7.dex */
public class a {
    private static a fyh;

    public static a bEw() {
        if (fyh == null) {
            fyh = bEx();
        }
        return fyh;
    }

    private static synchronized a bEx() {
        a aVar;
        synchronized (a.class) {
            if (fyh == null) {
                fyh = new a();
            }
            aVar = fyh;
        }
        return aVar;
    }

    private a() {
    }

    public File bEy() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bEz() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
