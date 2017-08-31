package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aMc = null;

    private a() {
    }

    public static synchronized a GU() {
        a aVar;
        synchronized (a.class) {
            if (aMc == null) {
                aMc = new a();
            }
            aVar = aMc;
        }
        return aVar;
    }

    public void GV() {
        String GW = GW();
        if (!TextUtils.isEmpty(GW)) {
            com.baidu.adp.lib.f.c.fK().a(GW, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GW() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
