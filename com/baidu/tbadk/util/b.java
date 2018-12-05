package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b bim = null;

    private b() {
    }

    public static synchronized b PI() {
        b bVar;
        synchronized (b.class) {
            if (bim == null) {
                bim = new b();
            }
            bVar = bim;
        }
        return bVar;
    }

    public void PJ() {
        String PK = PK();
        if (!TextUtils.isEmpty(PK)) {
            com.baidu.adp.lib.f.c.jA().a(PK, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String PK() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
