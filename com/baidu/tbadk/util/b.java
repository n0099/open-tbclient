package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b cDA = null;

    private b() {
    }

    public static synchronized b awl() {
        b bVar;
        synchronized (b.class) {
            if (cDA == null) {
                cDA = new b();
            }
            bVar = cDA;
        }
        return bVar;
    }

    public void awm() {
        String awn = awn();
        if (!TextUtils.isEmpty(awn)) {
            com.baidu.adp.lib.f.c.iE().a(awn, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String awn() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
