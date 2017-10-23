package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aLo = null;

    private a() {
    }

    public static synchronized a Gt() {
        a aVar;
        synchronized (a.class) {
            if (aLo == null) {
                aLo = new a();
            }
            aVar = aLo;
        }
        return aVar;
    }

    public void Gu() {
        String Gv = Gv();
        if (!TextUtils.isEmpty(Gv)) {
            com.baidu.adp.lib.f.c.fJ().a(Gv, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Gv() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
