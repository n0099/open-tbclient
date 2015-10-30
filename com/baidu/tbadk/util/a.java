package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a azz = null;

    private a() {
    }

    public static synchronized a Ep() {
        a aVar;
        synchronized (a.class) {
            if (azz == null) {
                azz = new a();
            }
            aVar = azz;
        }
        return aVar;
    }

    public void Eq() {
        String Er = Er();
        if (!TextUtils.isEmpty(Er)) {
            com.baidu.adp.lib.f.c.ha().a(Er, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Er() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
