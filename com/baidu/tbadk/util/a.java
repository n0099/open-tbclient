package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aIV = null;

    private a() {
    }

    public static synchronized a Gg() {
        a aVar;
        synchronized (a.class) {
            if (aIV == null) {
                aIV = new a();
            }
            aVar = aIV;
        }
        return aVar;
    }

    public void Gh() {
        String Gi = Gi();
        if (!TextUtils.isEmpty(Gi)) {
            com.baidu.adp.lib.f.c.fM().a(Gi, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Gi() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
