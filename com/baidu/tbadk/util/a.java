package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aNk = null;

    private a() {
    }

    public static synchronized a Hv() {
        a aVar;
        synchronized (a.class) {
            if (aNk == null) {
                aNk = new a();
            }
            aVar = aNk;
        }
        return aVar;
    }

    public void Hw() {
        String Hx = Hx();
        if (!TextUtils.isEmpty(Hx)) {
            com.baidu.adp.lib.f.c.fp().a(Hx, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Hx() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
