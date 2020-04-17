package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b egp = null;

    private b() {
    }

    public static synchronized b bab() {
        b bVar;
        synchronized (b.class) {
            if (egp == null) {
                egp = new b();
            }
            bVar = egp;
        }
        return bVar;
    }

    public void bac() {
        String bad = bad();
        if (!TextUtils.isEmpty(bad)) {
            com.baidu.adp.lib.e.c.kV().a(bad, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String bad() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
