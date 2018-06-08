package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aVj = null;

    private a() {
    }

    public static synchronized a KN() {
        a aVar;
        synchronized (a.class) {
            if (aVj == null) {
                aVj = new a();
            }
            aVar = aVj;
        }
        return aVar;
    }

    public void KO() {
        String KP = KP();
        if (!TextUtils.isEmpty(KP)) {
            com.baidu.adp.lib.f.c.ig().a(KP, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String KP() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
