package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static a eWX;

    public static a bpG() {
        if (eWX == null) {
            eWX = bpH();
        }
        return eWX;
    }

    private static synchronized a bpH() {
        a aVar;
        synchronized (a.class) {
            if (eWX == null) {
                eWX = new a();
            }
            aVar = eWX;
        }
        return aVar;
    }

    private a() {
    }

    public File bpI() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bpJ() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
