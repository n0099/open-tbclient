package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aWe = null;

    private a() {
    }

    public static synchronized a Lf() {
        a aVar;
        synchronized (a.class) {
            if (aWe == null) {
                aWe = new a();
            }
            aVar = aWe;
        }
        return aVar;
    }

    public void Lg() {
        String Lh = Lh();
        if (!TextUtils.isEmpty(Lh)) {
            com.baidu.adp.lib.f.c.ig().a(Lh, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Lh() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
