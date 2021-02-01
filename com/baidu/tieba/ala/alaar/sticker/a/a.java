package com.baidu.tieba.ala.alaar.sticker.a;

import java.io.File;
/* loaded from: classes11.dex */
public class a {
    private static a gtd;

    public static a bPN() {
        if (gtd == null) {
            gtd = bPO();
        }
        return gtd;
    }

    private static synchronized a bPO() {
        a aVar;
        synchronized (a.class) {
            if (gtd == null) {
                gtd = new a();
            }
            aVar = gtd;
        }
        return aVar;
    }

    private a() {
    }

    public File bPP() {
        return i.getPrivateCaptureRootChildDir("duModel");
    }

    public File bPQ() {
        return i.getPrivateCaptureRootChildDir("duSo");
    }
}
