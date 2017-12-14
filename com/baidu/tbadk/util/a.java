package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aMJ = null;

    private a() {
    }

    public static synchronized a GY() {
        a aVar;
        synchronized (a.class) {
            if (aMJ == null) {
                aMJ = new a();
            }
            aVar = aMJ;
        }
        return aVar;
    }

    public void GZ() {
        String Ha = Ha();
        if (!TextUtils.isEmpty(Ha)) {
            com.baidu.adp.lib.f.c.fJ().a(Ha, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Ha() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
