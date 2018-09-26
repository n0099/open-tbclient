package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b aZw = null;

    private b() {
    }

    public static synchronized b Mv() {
        b bVar;
        synchronized (b.class) {
            if (aZw == null) {
                aZw = new b();
            }
            bVar = aZw;
        }
        return bVar;
    }

    public void Mw() {
        String Mx = Mx();
        if (!TextUtils.isEmpty(Mx)) {
            com.baidu.adp.lib.f.c.jn().a(Mx, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Mx() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
