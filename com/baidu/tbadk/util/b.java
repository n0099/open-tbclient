package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b beL = null;

    private b() {
    }

    public static synchronized b OC() {
        b bVar;
        synchronized (b.class) {
            if (beL == null) {
                beL = new b();
            }
            bVar = beL;
        }
        return bVar;
    }

    public void OD() {
        String OE = OE();
        if (!TextUtils.isEmpty(OE)) {
            com.baidu.adp.lib.f.c.jA().a(OE, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String OE() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
