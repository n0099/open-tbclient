package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b dBQ = null;

    private b() {
    }

    public static synchronized b aPb() {
        b bVar;
        synchronized (b.class) {
            if (dBQ == null) {
                dBQ = new b();
            }
            bVar = dBQ;
        }
        return bVar;
    }

    public void aPc() {
        String aPd = aPd();
        if (!TextUtils.isEmpty(aPd)) {
            com.baidu.adp.lib.e.c.gs().a(aPd, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String aPd() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
