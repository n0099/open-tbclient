package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aLf = null;

    private a() {
    }

    public static synchronized a GN() {
        a aVar;
        synchronized (a.class) {
            if (aLf == null) {
                aLf = new a();
            }
            aVar = aLf;
        }
        return aVar;
    }

    public void GO() {
        String GP = GP();
        if (!TextUtils.isEmpty(GP)) {
            com.baidu.adp.lib.f.c.fJ().a(GP, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String GP() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
