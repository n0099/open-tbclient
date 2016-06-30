package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aAJ = null;

    private a() {
    }

    public static synchronized a Ft() {
        a aVar;
        synchronized (a.class) {
            if (aAJ == null) {
                aAJ = new a();
            }
            aVar = aAJ;
        }
        return aVar;
    }

    public void Fu() {
        String Fv = Fv();
        if (!TextUtils.isEmpty(Fv)) {
            com.baidu.adp.lib.g.c.dG().a(Fv, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Fv() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
