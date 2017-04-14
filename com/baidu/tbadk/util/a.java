package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aIR = null;

    private a() {
    }

    public static synchronized a Hc() {
        a aVar;
        synchronized (a.class) {
            if (aIR == null) {
                aIR = new a();
            }
            aVar = aIR;
        }
        return aVar;
    }

    public void Hd() {
        String He = He();
        if (!TextUtils.isEmpty(He)) {
            com.baidu.adp.lib.f.c.fL().a(He, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String He() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
