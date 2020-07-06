package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b eDM = null;

    private b() {
    }

    public static synchronized b biy() {
        b bVar;
        synchronized (b.class) {
            if (eDM == null) {
                eDM = new b();
            }
            bVar = eDM;
        }
        return bVar;
    }

    public void biz() {
        String biA = biA();
        if (!TextUtils.isEmpty(biA)) {
            com.baidu.adp.lib.e.c.ln().a(biA, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String biA() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
