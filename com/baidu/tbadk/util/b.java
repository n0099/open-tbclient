package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class b {
    private static b csW = null;

    private b() {
    }

    public static synchronized b apK() {
        b bVar;
        synchronized (b.class) {
            if (csW == null) {
                csW = new b();
            }
            bVar = csW;
        }
        return bVar;
    }

    public void apL() {
        String apM = apM();
        if (!TextUtils.isEmpty(apM)) {
            com.baidu.adp.lib.f.c.jB().a(apM, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String apM() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
