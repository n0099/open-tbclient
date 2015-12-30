package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aBZ = null;

    private a() {
    }

    public static synchronized a EY() {
        a aVar;
        synchronized (a.class) {
            if (aBZ == null) {
                aBZ = new a();
            }
            aVar = aBZ;
        }
        return aVar;
    }

    public void EZ() {
        String Fa = Fa();
        if (!TextUtils.isEmpty(Fa)) {
            com.baidu.adp.lib.g.c.hd().a(Fa, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Fa() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
