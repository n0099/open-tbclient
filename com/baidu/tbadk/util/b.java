package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b dGs = null;

    private b() {
    }

    public static synchronized b aRO() {
        b bVar;
        synchronized (b.class) {
            if (dGs == null) {
                dGs = new b();
            }
            bVar = dGs;
        }
        return bVar;
    }

    public void aRP() {
        String aRQ = aRQ();
        if (!TextUtils.isEmpty(aRQ)) {
            com.baidu.adp.lib.e.c.gr().a(aRQ, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String aRQ() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
