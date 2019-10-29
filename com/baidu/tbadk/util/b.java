package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b cOJ = null;

    private b() {
    }

    public static synchronized b axq() {
        b bVar;
        synchronized (b.class) {
            if (cOJ == null) {
                cOJ = new b();
            }
            bVar = cOJ;
        }
        return bVar;
    }

    public void axr() {
        String axs = axs();
        if (!TextUtils.isEmpty(axs)) {
            com.baidu.adp.lib.f.c.fT().a(axs, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String axs() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
