package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a bAQ = null;

    private a() {
    }

    public static synchronized a On() {
        a aVar;
        synchronized (a.class) {
            if (bAQ == null) {
                bAQ = new a();
            }
            aVar = bAQ;
        }
        return aVar;
    }

    public void Oo() {
        String Op = Op();
        if (!TextUtils.isEmpty(Op)) {
            com.baidu.adp.lib.f.c.nm().a(Op, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Op() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
