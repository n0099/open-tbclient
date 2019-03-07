package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b csW = null;

    private b() {
    }

    public static synchronized b apN() {
        b bVar;
        synchronized (b.class) {
            if (csW == null) {
                csW = new b();
            }
            bVar = csW;
        }
        return bVar;
    }

    public void apO() {
        String apP = apP();
        if (!TextUtils.isEmpty(apP)) {
            com.baidu.adp.lib.f.c.jB().a(apP, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String apP() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
