package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aLX = null;

    private a() {
    }

    public static synchronized a GF() {
        a aVar;
        synchronized (a.class) {
            if (aLX == null) {
                aLX = new a();
            }
            aVar = aLX;
        }
        return aVar;
    }

    public void GG() {
        String GH = GH();
        if (!TextUtils.isEmpty(GH)) {
            com.baidu.adp.lib.f.c.fJ().a(GH, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GH() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
