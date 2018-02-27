package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a bCH = null;

    private a() {
    }

    public static synchronized a OR() {
        a aVar;
        synchronized (a.class) {
            if (bCH == null) {
                bCH = new a();
            }
            aVar = bCH;
        }
        return aVar;
    }

    public void OS() {
        String OT = OT();
        if (!TextUtils.isEmpty(OT)) {
            com.baidu.adp.lib.f.c.nm().a(OT, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String OT() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
