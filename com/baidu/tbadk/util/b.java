package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b egu = null;

    private b() {
    }

    public static synchronized b aZZ() {
        b bVar;
        synchronized (b.class) {
            if (egu == null) {
                egu = new b();
            }
            bVar = egu;
        }
        return bVar;
    }

    public void baa() {
        String bab = bab();
        if (!TextUtils.isEmpty(bab)) {
            com.baidu.adp.lib.e.c.kV().a(bab, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String bab() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
