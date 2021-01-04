package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes11.dex */
public class a {
    private static a gva;

    public static a bTa() {
        if (gva == null) {
            gva = bTb();
        }
        return gva;
    }

    private static synchronized a bTb() {
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

    public File bTc() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bTd() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
