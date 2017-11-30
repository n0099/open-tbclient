package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aMG = null;

    private a() {
    }

    public static synchronized a GX() {
        a aVar;
        synchronized (a.class) {
            if (aMG == null) {
                aMG = new a();
            }
            aVar = aMG;
        }
        return aVar;
    }

    public void GY() {
        String GZ = GZ();
        if (!TextUtils.isEmpty(GZ)) {
            com.baidu.adp.lib.f.c.fJ().a(GZ, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GZ() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
