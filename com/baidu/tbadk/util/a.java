package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a bCK = null;

    private a() {
    }

    public static synchronized a OS() {
        a aVar;
        synchronized (a.class) {
            if (bCK == null) {
                bCK = new a();
            }
            aVar = bCK;
        }
        return aVar;
    }

    public void OT() {
        String OU = OU();
        if (!TextUtils.isEmpty(OU)) {
            com.baidu.adp.lib.f.c.nm().a(OU, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String OU() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
