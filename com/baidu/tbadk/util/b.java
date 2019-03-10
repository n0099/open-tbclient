package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b csW = null;

    private b() {
    }

    public static synchronized b apO() {
        b bVar;
        synchronized (b.class) {
            if (csW == null) {
                csW = new b();
            }
            bVar = csW;
        }
        return bVar;
    }

    public void apP() {
        String apQ = apQ();
        if (!TextUtils.isEmpty(apQ)) {
            com.baidu.adp.lib.f.c.jB().a(apQ, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String apQ() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
