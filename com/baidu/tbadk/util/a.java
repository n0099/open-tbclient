package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aWg = null;

    private a() {
    }

    public static synchronized a Le() {
        a aVar;
        synchronized (a.class) {
            if (aWg == null) {
                aWg = new a();
            }
            aVar = aWg;
        }
        return aVar;
    }

    public void Lf() {
        String Lg = Lg();
        if (!TextUtils.isEmpty(Lg)) {
            com.baidu.adp.lib.f.c.ih().a(Lg, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Lg() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
