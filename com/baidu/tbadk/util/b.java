package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b dGe = null;

    private b() {
    }

    public static synchronized b aRL() {
        b bVar;
        synchronized (b.class) {
            if (dGe == null) {
                dGe = new b();
            }
            bVar = dGe;
        }
        return bVar;
    }

    public void aRM() {
        String aRN = aRN();
        if (!TextUtils.isEmpty(aRN)) {
            com.baidu.adp.lib.e.c.gr().a(aRN, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String aRN() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
