package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aDe = null;

    private a() {
    }

    public static synchronized a Ge() {
        a aVar;
        synchronized (a.class) {
            if (aDe == null) {
                aDe = new a();
            }
            aVar = aDe;
        }
        return aVar;
    }

    public void Gf() {
        String Gg = Gg();
        if (!TextUtils.isEmpty(Gg)) {
            com.baidu.adp.lib.f.c.ey().a(Gg, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Gg() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
