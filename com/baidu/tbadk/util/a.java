package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aII = null;

    private a() {
    }

    public static synchronized a Ga() {
        a aVar;
        synchronized (a.class) {
            if (aII == null) {
                aII = new a();
            }
            aVar = aII;
        }
        return aVar;
    }

    public void Gb() {
        String Gc = Gc();
        if (!TextUtils.isEmpty(Gc)) {
            com.baidu.adp.lib.f.c.fM().a(Gc, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Gc() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
