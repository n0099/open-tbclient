package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes4.dex */
public class a {
    private static a fWQ;

    public static a bKX() {
        if (fWQ == null) {
            fWQ = bKY();
        }
        return fWQ;
    }

    private static synchronized a bKY() {
        a aVar;
        synchronized (a.class) {
            if (fWQ == null) {
                fWQ = new a();
            }
            aVar = fWQ;
        }
        return aVar;
    }

    private a() {
    }

    public File bKZ() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bLa() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
