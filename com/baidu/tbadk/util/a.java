package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aEo = null;

    private a() {
    }

    public static synchronized a Gm() {
        a aVar;
        synchronized (a.class) {
            if (aEo == null) {
                aEo = new a();
            }
            aVar = aEo;
        }
        return aVar;
    }

    public void Gn() {
        String Go = Go();
        if (!TextUtils.isEmpty(Go)) {
            com.baidu.adp.lib.g.c.eA().a(Go, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Go() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
