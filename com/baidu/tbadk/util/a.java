package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a bAI = null;

    private a() {
    }

    public static synchronized a Ol() {
        a aVar;
        synchronized (a.class) {
            if (bAI == null) {
                bAI = new a();
            }
            aVar = bAI;
        }
        return aVar;
    }

    public void Om() {
        String On = On();
        if (!TextUtils.isEmpty(On)) {
            com.baidu.adp.lib.f.c.nl().a(On, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String On() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
