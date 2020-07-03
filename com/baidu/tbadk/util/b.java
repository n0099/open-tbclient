package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b eDM = null;

    private b() {
    }

    public static synchronized b bix() {
        b bVar;
        synchronized (b.class) {
            if (eDM == null) {
                eDM = new b();
            }
            bVar = eDM;
        }
        return bVar;
    }

    public void biy() {
        String biz = biz();
        if (!TextUtils.isEmpty(biz)) {
            com.baidu.adp.lib.e.c.ln().a(biz, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String biz() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
