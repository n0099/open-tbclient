package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aEU = null;

    private a() {
    }

    public static synchronized a GQ() {
        a aVar;
        synchronized (a.class) {
            if (aEU == null) {
                aEU = new a();
            }
            aVar = aEU;
        }
        return aVar;
    }

    public void GR() {
        String GS = GS();
        if (!TextUtils.isEmpty(GS)) {
            com.baidu.adp.lib.g.c.eA().a(GS, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GS() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
