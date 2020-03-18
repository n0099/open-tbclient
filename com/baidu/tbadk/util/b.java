package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b {
    private static b dGI = null;

    private b() {
    }

    public static synchronized b aRS() {
        b bVar;
        synchronized (b.class) {
            if (dGI == null) {
                dGI = new b();
            }
            bVar = dGI;
        }
        return bVar;
    }

    public void aRT() {
        String aRU = aRU();
        if (!TextUtils.isEmpty(aRU)) {
            com.baidu.adp.lib.e.c.gr().a(aRU, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String aRU() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
