package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b cBf = null;

    private b() {
    }

    public static synchronized b auO() {
        b bVar;
        synchronized (b.class) {
            if (cBf == null) {
                cBf = new b();
            }
            bVar = cBf;
        }
        return bVar;
    }

    public void auP() {
        String auQ = auQ();
        if (!TextUtils.isEmpty(auQ)) {
            com.baidu.adp.lib.f.c.iv().a(auQ, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String auQ() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
