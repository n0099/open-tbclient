package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static a eXi;

    public static a bpI() {
        if (eXi == null) {
            eXi = bpJ();
        }
        return eXi;
    }

    private static synchronized a bpJ() {
        a aVar;
        synchronized (a.class) {
            if (eXi == null) {
                eXi = new a();
            }
            aVar = eXi;
        }
        return aVar;
    }

    private a() {
    }

    public File bpK() {
        return h.getPrivateCaptureRootChildDir("duModel");
    }

    public File bpL() {
        return h.getPrivateCaptureRootChildDir("duSo");
    }
}
