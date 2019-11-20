package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b cNS = null;

    private b() {
    }

    public static synchronized b axo() {
        b bVar;
        synchronized (b.class) {
            if (cNS == null) {
                cNS = new b();
            }
            bVar = cNS;
        }
        return bVar;
    }

    public void axp() {
        String axq = axq();
        if (!TextUtils.isEmpty(axq)) {
            com.baidu.adp.lib.f.c.fT().a(axq, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String axq() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
