package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aEG = null;

    private a() {
    }

    public static synchronized a GO() {
        a aVar;
        synchronized (a.class) {
            if (aEG == null) {
                aEG = new a();
            }
            aVar = aEG;
        }
        return aVar;
    }

    public void GP() {
        String GQ = GQ();
        if (!TextUtils.isEmpty(GQ)) {
            com.baidu.adp.lib.g.c.eA().a(GQ, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GQ() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
