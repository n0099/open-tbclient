package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aNl = null;

    private a() {
    }

    public static synchronized a Ht() {
        a aVar;
        synchronized (a.class) {
            if (aNl == null) {
                aNl = new a();
            }
            aVar = aNl;
        }
        return aVar;
    }

    public void Hu() {
        String Hv = Hv();
        if (!TextUtils.isEmpty(Hv)) {
            com.baidu.adp.lib.f.c.fp().a(Hv, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Hv() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
