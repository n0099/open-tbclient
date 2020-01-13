package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b dCa = null;

    private b() {
    }

    public static synchronized b aPu() {
        b bVar;
        synchronized (b.class) {
            if (dCa == null) {
                dCa = new b();
            }
            bVar = dCa;
        }
        return bVar;
    }

    public void aPv() {
        String aPw = aPw();
        if (!TextUtils.isEmpty(aPw)) {
            com.baidu.adp.lib.e.c.gr().a(aPw, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String aPw() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
