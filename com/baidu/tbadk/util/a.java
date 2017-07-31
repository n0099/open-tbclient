package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aMu = null;

    private a() {
    }

    public static synchronized a GV() {
        a aVar;
        synchronized (a.class) {
            if (aMu == null) {
                aMu = new a();
            }
            aVar = aMu;
        }
        return aVar;
    }

    public void GW() {
        String GX = GX();
        if (!TextUtils.isEmpty(GX)) {
            com.baidu.adp.lib.f.c.fU().a(GX, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GX() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
