package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aIB = null;

    private a() {
    }

    public static synchronized a GD() {
        a aVar;
        synchronized (a.class) {
            if (aIB == null) {
                aIB = new a();
            }
            aVar = aIB;
        }
        return aVar;
    }

    public void GE() {
        String GF = GF();
        if (!TextUtils.isEmpty(GF)) {
            com.baidu.adp.lib.f.c.fG().a(GF, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GF() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
