package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b cCE = null;

    private b() {
    }

    public static synchronized b avZ() {
        b bVar;
        synchronized (b.class) {
            if (cCE == null) {
                cCE = new b();
            }
            bVar = cCE;
        }
        return bVar;
    }

    public void awa() {
        String awb = awb();
        if (!TextUtils.isEmpty(awb)) {
            com.baidu.adp.lib.f.c.iE().a(awb, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String awb() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
