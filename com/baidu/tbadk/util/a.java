package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aJX = null;

    private a() {
    }

    public static synchronized a Gx() {
        a aVar;
        synchronized (a.class) {
            if (aJX == null) {
                aJX = new a();
            }
            aVar = aJX;
        }
        return aVar;
    }

    public void Gy() {
        String Gz = Gz();
        if (!TextUtils.isEmpty(Gz)) {
            com.baidu.adp.lib.f.c.fL().a(Gz, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Gz() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
