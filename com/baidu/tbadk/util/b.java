package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b cCx = null;

    private b() {
    }

    public static synchronized b avX() {
        b bVar;
        synchronized (b.class) {
            if (cCx == null) {
                cCx = new b();
            }
            bVar = cCx;
        }
        return bVar;
    }

    public void avY() {
        String avZ = avZ();
        if (!TextUtils.isEmpty(avZ)) {
            com.baidu.adp.lib.f.c.iE().a(avZ, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String avZ() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
