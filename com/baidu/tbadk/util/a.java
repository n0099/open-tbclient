package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aBz = null;

    private a() {
    }

    public static synchronized a Fu() {
        a aVar;
        synchronized (a.class) {
            if (aBz == null) {
                aBz = new a();
            }
            aVar = aBz;
        }
        return aVar;
    }

    public void Fv() {
        String Fw = Fw();
        if (!TextUtils.isEmpty(Fw)) {
            com.baidu.adp.lib.g.c.dF().a(Fw, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Fw() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
