package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a bAz = null;

    private a() {
    }

    public static synchronized a Ox() {
        a aVar;
        synchronized (a.class) {
            if (bAz == null) {
                bAz = new a();
            }
            aVar = bAz;
        }
        return aVar;
    }

    public void Oy() {
        String Oz = Oz();
        if (!TextUtils.isEmpty(Oz)) {
            com.baidu.adp.lib.f.c.nl().a(Oz, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Oz() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
