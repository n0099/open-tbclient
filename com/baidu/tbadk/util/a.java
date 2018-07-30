package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aWg = null;

    private a() {
    }

    public static synchronized a La() {
        a aVar;
        synchronized (a.class) {
            if (aWg == null) {
                aWg = new a();
            }
            aVar = aWg;
        }
        return aVar;
    }

    public void Lb() {
        String Lc = Lc();
        if (!TextUtils.isEmpty(Lc)) {
            com.baidu.adp.lib.f.c.ih().a(Lc, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Lc() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
