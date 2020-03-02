package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b dGf = null;

    private b() {
    }

    public static synchronized b aRN() {
        b bVar;
        synchronized (b.class) {
            if (dGf == null) {
                dGf = new b();
            }
            bVar = dGf;
        }
        return bVar;
    }

    public void aRO() {
        String aRP = aRP();
        if (!TextUtils.isEmpty(aRP)) {
            com.baidu.adp.lib.e.c.gr().a(aRP, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String aRP() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
