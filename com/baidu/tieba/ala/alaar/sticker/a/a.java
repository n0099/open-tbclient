package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes10.dex */
public class a {
    private static a gqt;

    public static a bPj() {
        if (gqt == null) {
            gqt = bPk();
        }
        return gqt;
    }

    private static synchronized a bPk() {
        a aVar;
        synchronized (a.class) {
            if (gqt == null) {
                gqt = new a();
            }
            aVar = gqt;
        }
        return aVar;
    }

    private a() {
    }

    public File bPl() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bPm() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
