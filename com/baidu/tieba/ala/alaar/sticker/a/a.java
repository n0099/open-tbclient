package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes11.dex */
public class a {
    private static a gva;

    public static a bTb() {
        if (gva == null) {
            gva = bTc();
        }
        return gva;
    }

    private static synchronized a bTc() {
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

    public File bTd() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bTe() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
