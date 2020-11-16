package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a gco;

    public static a bMP() {
        if (gco == null) {
            gco = bMQ();
        }
        return gco;
    }

    private static synchronized a bMQ() {
        a aVar;
        synchronized (a.class) {
            if (gco == null) {
                gco = new a();
            }
            aVar = gco;
        }
        return aVar;
    }

    private a() {
    }

    public File bMR() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bMS() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
