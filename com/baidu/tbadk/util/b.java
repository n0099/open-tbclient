package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b bip = null;

    private b() {
    }

    public static synchronized b PK() {
        b bVar;
        synchronized (b.class) {
            if (bip == null) {
                bip = new b();
            }
            bVar = bip;
        }
        return bVar;
    }

    public void PL() {
        String PM = PM();
        if (!TextUtils.isEmpty(PM)) {
            com.baidu.adp.lib.f.c.jA().a(PM, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String PM() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
