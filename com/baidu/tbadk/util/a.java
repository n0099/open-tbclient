package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aLB = null;

    private a() {
    }

    public static synchronized a Gz() {
        a aVar;
        synchronized (a.class) {
            if (aLB == null) {
                aLB = new a();
            }
            aVar = aLB;
        }
        return aVar;
    }

    public void GA() {
        String GB = GB();
        if (!TextUtils.isEmpty(GB)) {
            com.baidu.adp.lib.f.c.fJ().a(GB, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GB() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
